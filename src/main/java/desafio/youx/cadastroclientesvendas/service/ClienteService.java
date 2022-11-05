package desafio.youx.cadastroclientesvendas.service;


import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.repository.ClienteRepository;
import desafio.youx.cadastroclientesvendas.requests.ClientePostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.ClientePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public Cliente findByIdOrThrowBadRequestException(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente notFound"));

    }

    public Cliente save(ClientePostRequestBody clientePostRequestBody) {
        return clienteRepository.save(Cliente.builder()
                .nome(clientePostRequestBody.getNome())
                .CNPJ(clientePostRequestBody.getCNPJ())
                .email(clientePostRequestBody.getEmail())
                .telefone(clientePostRequestBody.getTelefone())
                .UF(clientePostRequestBody.getUF())
                .localizacao(clientePostRequestBody.getLocalizacao())
                .build());

    }

    public void delete(long id) { clienteRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ClientePutRequestBody clientePutRequestBody) {
        findByIdOrThrowBadRequestException(clientePutRequestBody.getId());
        Cliente cliente = Cliente.builder()
                .id(clientePutRequestBody.getId())
                .nome(clientePutRequestBody.getNome())
                .CNPJ(clientePutRequestBody.getCNPJ())
                .email(clientePutRequestBody.getEmail())
                .telefone(clientePutRequestBody.getTelefone())
                .UF(clientePutRequestBody.getUF())
                .localizacao(clientePutRequestBody.getLocalizacao()).build();
        clienteRepository.save(cliente);

    }
}
