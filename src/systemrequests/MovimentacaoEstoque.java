package systemrequests;

import java.util.Date;

class MovimentacaoEstoque {
	
	private NewItens item;
    private String tipo; 
    private int quantidade;
    private Date data;

    public MovimentacaoEstoque(NewItens item, String tipo, int quantidade, Date data) {
        this.item = item;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public NewItens getItem() {
        return item;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getData() {
        return data;
    }
}


