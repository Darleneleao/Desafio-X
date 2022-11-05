package desafio.youx.cadastroclientesvendas.requests;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VendaPutRequestBody {
    private Long id;
    private Cliente cliente;
    private Date data;
    private String status;
    private double valor;


}
