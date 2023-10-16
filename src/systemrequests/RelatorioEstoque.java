package systemrequests;

import java.util.List;

public class RelatorioEstoque {

	public static void gerarRelatorio(List<NewItens> estoque) {
	System.out.println("Relatório de Estoque");
	        System.out.println("---------~~---------");
	        
	        for (NewItens item : estoque) {
	            System.out.println("Item: " + item.getNome());
	            System.out.println("Quantidade em Estoque: " + item.getQuantidade());
	            System.out.println("---------~~---------");
	        }
	}
}
