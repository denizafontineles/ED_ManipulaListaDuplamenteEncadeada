package view;
import javax.swing.JOptionPane;
import controller.ManipulaListaDupla;
import com.deniza.utils.ListaDuplaEncadeadaInt.ListaDuplaEncadeadaInt;

public class Main {
	
	public static void main(String[] args) {
		ManipulaListaDupla op = new ManipulaListaDupla();
		ListaDuplaEncadeadaInt l1 = new ListaDuplaEncadeadaInt();
		ListaDuplaEncadeadaInt l2 = new ListaDuplaEncadeadaInt();
		ListaDuplaEncadeadaInt aux = new ListaDuplaEncadeadaInt();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 0:
				int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 1\nDigite um número"));
				op.insere(numero, l1);
				break;
			
			case 1:
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 2\nDigite um número"));
				op.insere(numero, l2);
				break;
			
			case 2:
				try {
					aux = op.concatena(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 3:
				try {
					aux = op.intercala(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				int lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja dividir?"
						+ "\nDigite 1 ou 2"));
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de "
						+ "sublistas desejadas"));
				try {
					if(lista == 1) {
						ListaDuplaEncadeadaInt[] vetor = op.divide(l1, numero);
						for(ListaDuplaEncadeadaInt i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					} else {
						ListaDuplaEncadeadaInt[] vetor = op.divide(l2, numero);
						for(ListaDuplaEncadeadaInt i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 9:
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Digite uma opção:\n");
		buffer.append("0 - Inserir um número à lista no. 1\n");
		buffer.append("1 - Inserir um número à lista no. 2\n");
		buffer.append("2 - Concatenar as duas listas\n");
		buffer.append("3 - Intercalar as duas listas\n");
		buffer.append("4 - Dividir uma lista (criar sublistas)\n");
		buffer.append("9 - Encerra a aplicação\n");

		return buffer.toString();
	}

}
