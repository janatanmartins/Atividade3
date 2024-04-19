package principal;



import java.io.IOException;

import javax.swing.JOptionPane;

import funcao.Arquivo;
import funcao.Funcao;
import model.Carro;

public class Principal {

	public static void main(String[] args) throws IOException {
        Carro carro = new Carro();
        Funcao funcao = new Funcao();
        Arquivo arq = new Arquivo();
        String arquivo;
        
        arq.printcarro();
        arq.multaTransito(); 
        
        
        arquivo = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
        arq.writeFile(arquivo);
      
       
        
        
    }

 
}
