package desafio.youx.cadastroclientesvendas.requests;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VendaPostRequestBody {
    private Cliente cliente;
    private String status;
    private double valor;




}
