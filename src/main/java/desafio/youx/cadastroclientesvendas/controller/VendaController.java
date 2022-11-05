package desafio.youx.cadastroclientesvendas.controller;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import desafio.youx.cadastroclientesvendas.requests.ClientePostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.ClientePutRequestBody;
import desafio.youx.cadastroclientesvendas.requests.VendaPostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.VendaPutRequestBody;
import desafio.youx.cadastroclientesvendas.service.ClienteService;
import desafio.youx.cadastroclientesvendas.service.VendaService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("vendas")
@Log4j2
@AllArgsConstructor
public class VendaController {
    private final VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> list(){
        return ResponseEntity.ok(vendaService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Venda> findById(@PathVariable long id){
        return ResponseEntity.ok(vendaService.findByIdOrThrowBadRequestException(id));

    }

    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody VendaPostRequestBody vendaPostRequestBody){
        return new ResponseEntity<>(vendaService.save(vendaPostRequestBody), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        vendaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VendaPutRequestBody vendaPutRequestBody){
    vendaService.replace(vendaPutRequestBody);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    }
