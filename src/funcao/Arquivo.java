package funcao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Carro;

public class Arquivo {
	
	static Carro c = new Carro();
	List<Carro> list = new ArrayList<>();
	public void readCarro(String arquivo) throws IOException {
		String path = "home/desenvolvimento/Documentos/eclipse-workspace/Atividade/src/temp" + arquivo;
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			while(line != null);
			
			String[] vect = line.split(";");
			String modelo = vect[0];
			String placa = vect[1];
			int ano = Integer.parseInt(vect[2]);
			String cor = vect[3];
			int velocidadeCarro = Integer.parseInt(vect[4]);
			
			Carro prod = new Carro(modelo, placa, ano, cor,velocidadeCarro); 
			list.add(prod);
			
			line = br.readLine();
			
		}
		JOptionPane.showMessageDialog(null, "Informaçoes da multa: ");
		for (Carro c :list) {
			JOptionPane.showMessageDialog(null, c);
		}
	}
	
	public void printcarro() {
		int ano, velocidadeCarro;
		String sano, svelocidadeCarro;
		
		c.setModelo(JOptionPane.showInputDialog("Digite o modelo do carro: "));
		c.setPlaca(JOptionPane.showInputDialog("Digite a Placa do carro: "));
		sano = JOptionPane.showInputDialog("Digite o ano de fabricação: ");
		c.setAno(ano = Integer.parseInt(sano));
		c.setCor(JOptionPane.showInputDialog("Digite a cor do carro: "));
		svelocidadeCarro = JOptionPane.showInputDialog("Digite a velocidade do carro: ");
		c.setVelocidadeCarro(Integer.parseInt(svelocidadeCarro));
		
		
		JOptionPane.showMessageDialog(null, "Os dados co carro são: Modelo: "+ c.getModelo()
																	+ " Placa: " + c.getPlaca()
																	+ " Ano: "+ c.getAno()
																	+ " Cor: " + c.getCor()
																	+ " Velocidade: " + c.getVelocidadeCarro());
	}
	
	   public static void multaTransito() {
	    	int velocidadeVia = 80;
	        int velocidadeExcedida = c.getVelocidadeCarro() - velocidadeVia;
	        if (velocidadeExcedida > 0) {
	            double multa = calcularMulta(velocidadeExcedida, velocidadeExcedida);
	            JOptionPane.showMessageDialog(null, "Multa a ser paga: R$" + multa);
	        } else {
	        	JOptionPane.showMessageDialog(null, "O carro está dentro do limite de velocidade.");
	        }
	    }

	    public static double calcularMulta(int velocidadeExcedida, int velocidadeVia) {
	        double multa;
	        if (velocidadeExcedida <= 10) {
	            multa = 130.00;
	        } else if (velocidadeExcedida <= 20) {
	            multa = 230.00;
	        } else if (velocidadeExcedida <= 30) {
	            multa = 580.00;
	        } else {
	            multa = 967.52;
	        }
	        return multa;
	    }
	    
	    public void writeFile(String arquivo) throws IOException{
//			String path = "/home/fennder/Documents/Workspace/eclipse-workspace/JavaProject/src/tmp/" + arquivo;
			File path = new File("/home/desenvolvimento/Documentos/eclipse-workspace/Atividade/src/temp" + arquivo);
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
				System.out.println();

				bw.write(c.getModelo());
				bw.write(",");
				bw.write(c.getPlaca());
				bw.write(",");
				bw.write(c.getAno());
				bw.write(",");
				bw.write(c.getCor());
				bw.write(",");
				bw.write(c.getVelocidadeCarro());
				bw.write(",");
				bw.close();
							
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		


}
