package systemrequests;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class RegisterItem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<NewItens> estoque = new ArrayList<>();
		
	
		while (true) {
			System.out.print("Opções: \n");
			System.out.print("\n1. Adicionar Item");
			System.out.print("\n2. Listar Itens");
			System.out.print("\n3. Saída de Item" );
			System.out.print("\n4. Histórico de Item");
			System.out.print("\n5. Relatório de Estoque");
			System.out.print("\n6. Sair\n");
			int opcao = sc.nextInt();
			
			switch (opcao) {
			
			case 1:
				
				System.out.print("Nome do item: ");
				String nomeItem = sc.next();
				System.out.print("Quantidade: ");
				int quantidade = sc.nextInt();
				
				 // cria um novo objeto Date para a data de entrada
			    Date dataAtualEntrada = new Date();

			    // verifica se o item já está no estoque
			    boolean itemExistente = false;
			    for (NewItens estoqueItem : estoque) {
			        if (estoqueItem.getNome().equalsIgnoreCase(nomeItem)) {
			            // se o item já existe, aumente a quantidade existente
			            estoqueItem.setQuantidade(estoqueItem.getQuantidade() + quantidade);
			            
			            // atualiza a data de entrada
			            estoqueItem.setDataEntrada(dataAtualEntrada);
			            
			            // adiciona uma nova entrada no histórico
			            MovimentacaoEstoque movimentacaoEntrada = new MovimentacaoEstoque(estoqueItem, "Entrada", quantidade, dataAtualEntrada);
			            estoqueItem.getHistoricoMovimentacoes().add(movimentacaoEntrada);
			            
			            itemExistente = true;
			            System.out.println("\nQuantidade atualizada no estoque.\n");
			            break;
			        }
			    }

			    if (!itemExistente) {
			        
			        NewItens item = new NewItens(nomeItem, quantidade);
			        item.setDataEntrada(dataAtualEntrada);
			        estoque.add(item);

				
			    MovimentacaoEstoque movimentacaoEntrada = new MovimentacaoEstoque(item, "Entrada", quantidade, dataAtualEntrada);
			    item.getHistoricoMovimentacoes().add(movimentacaoEntrada);
			    
				System.out.print("\nItem adicionado no estoque\n");
				
				
			    }
			    break;
			    
			case 2:
				
				System.out.print("\nItens em estoque:\n\n");
				for (NewItens registerIten : estoque){
					System.out.println(registerIten);
				}
				break;
				
			case 3:
				System.out.print("Nome do item a ser registrado como saída: ");
                String nomeSaida = sc.next();
                System.out.print("Quantidade: ");
                int quantidadeSaida = sc.nextInt();

                // cria um novo objeto Date para a data de saída
                Date dataAtualSaida = new Date();
                
                boolean itemEncontrado = false; // verifica se o item foi encontrado

                
                for (NewItens estoqueItem : estoque) {
                    if (estoqueItem.getNome().equalsIgnoreCase(nomeSaida)) {
                        if (estoqueItem.getQuantidade() >= quantidadeSaida) {
                            estoqueItem.setQuantidade(estoqueItem.getQuantidade() - quantidadeSaida);
                            
                         // define a data de saída para o item
                            estoqueItem.setDataSaida(dataAtualSaida);
                         
                         // movimentação de saída e adicione ao histórico
                            MovimentacaoEstoque movimentacaoSaida = new MovimentacaoEstoque(estoqueItem, "Saída", quantidadeSaida, dataAtualSaida);
                            estoqueItem.getHistoricoMovimentacoes().add(movimentacaoSaida);
                            
                            System.out.println("Saída registrada com sucesso.");
                        } else {
                            System.out.println("Quantidade insuficiente em estoque.");
                        }
                        itemEncontrado = true; // item encontrado
                        break;
                    }
                }
                if (!itemEncontrado) {
                    System.out.println("Item não encontrado no estoque.");
                }
                break;
                
			case 4:
				
				System.out.print("Digite o nome do item para ver o histórico: ");
				String nomeHistorico = sc.next();
				boolean itemEncontrado2 = false;

			    for (NewItens estoqueItem : estoque) {
			        if (estoqueItem.getNome().equalsIgnoreCase(nomeHistorico)) {
			            itemEncontrado2 = true;
			            List<MovimentacaoEstoque> historico = estoqueItem.getHistoricoMovimentacoes();
			            if (historico.isEmpty()) {
			                System.out.println("O histórico para este item está vazio.\n");
			            } else {
			                System.out.println("\nHistórico de movimentações para o item " + nomeHistorico + ":");
			                for (MovimentacaoEstoque movimentacao : historico) {
			                    System.out.println("\nTipo: " + movimentacao.getTipo());
			                    System.out.println("Quantidade: " + movimentacao.getQuantidade());
			                    System.out.println("Data: " + movimentacao.getData());
			                    System.out.println("\n------------------------");
			                }
			            }
			        }
			    }

			    if (!itemEncontrado2) {
			        System.out.println("Item não encontrado no estoque.");
			    }
			    break;

			case 5:
				
				 RelatorioEstoque.gerarRelatorio(estoque);
				    break;
			case 6:
				
				System.out.println("\nEncerrando o programa.\n");
				sc.close();
				System.exit(0);
					
				default:
				System.out.println("\nOpção inválida. Tente novamente.\n");
					
			}
		}
	}
}
