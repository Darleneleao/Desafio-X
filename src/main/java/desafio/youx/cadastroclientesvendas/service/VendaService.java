package desafio.youx.cadastroclientesvendas.service;


import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import desafio.youx.cadastroclientesvendas.repository.ClienteRepository;
import desafio.youx.cadastroclientesvendas.repository.VendaRepository;
import desafio.youx.cadastroclientesvendas.requests.ClientePostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.ClientePutRequestBody;
import desafio.youx.cadastroclientesvendas.requests.VendaPostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.VendaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    public List<Venda> listAll() {
        return vendaRepository.findAll();
    }

    public Venda findByIdOrThrowBadRequestException(long id) {
        return vendaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Venda notFound"));

    }

    public Venda save(VendaPostRequestBody vendaPostRequestBody) {
        return vendaRepository.save(Venda.builder()
                .cliente(vendaPostRequestBody.getCliente())
                .data(new Date())
                .status(vendaPostRequestBody.getStatus())
                .valor(vendaPostRequestBody.getValor())
                .build());

    }

    public void delete(long id) { vendaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(VendaPutRequestBody vendaPutRequestBody) {
        findByIdOrThrowBadRequestException(vendaPutRequestBody.getId());
        Venda venda = Venda.builder()
                .cliente(vendaPutRequestBody.getCliente())
                .data(vendaPutRequestBody.getData())
                .status(vendaPutRequestBody.getStatus())
                .valor(vendaPutRequestBody.getValor())
                .build();
        vendaRepository.save(venda);

    }
}
