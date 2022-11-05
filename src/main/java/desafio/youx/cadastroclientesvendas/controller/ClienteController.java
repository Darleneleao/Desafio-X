package desafio.youx.cadastroclientesvendas.controller;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import desafio.youx.cadastroclientesvendas.requests.ClientePostRequestBody;
import desafio.youx.cadastroclientesvendas.requests.ClientePutRequestBody;
import desafio.youx.cadastroclientesvendas.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@Log4j2
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));

    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody  clientePostRequestBody){
        return new ResponseEntity<>(clienteService.save(clientePostRequestBody), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClientePutRequestBody clientePutRequestBody){
    clienteService.replace(clientePutRequestBody);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    }
