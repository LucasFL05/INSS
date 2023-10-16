package systemrequests;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


class NewItens {
	
	private String nome;
	private int quantidade;
	
    private List<MovimentacaoEstoque> historicoMovimentacoes; // Lista de histórico de movimentações
	
	public NewItens(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.historicoMovimentacoes = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return "Item: " + nome + ", quantidade: " +quantidade;
		
	}

	public void setDataSaida(Date dataAtualSaida) {
		
	}

	public void setDataEntrada(Date dataAtualEntrada) {
		
	}
	public List<MovimentacaoEstoque> getHistoricoMovimentacoes() {
        return historicoMovimentacoes;
	}
}
