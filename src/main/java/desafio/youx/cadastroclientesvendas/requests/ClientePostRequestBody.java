package desafio.youx.cadastroclientesvendas.requests;

import desafio.youx.cadastroclientesvendas.domain.Venda;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientePostRequestBody {
    private String nome;
    private String CNPJ;
    private String email;
    private String telefone;
    private String UF;
    private String localizacao;
    private List<Venda> vendaList;


}
