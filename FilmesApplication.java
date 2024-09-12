package br.edu.fatecpg.filmes.view;

import br.edu.fatecpg.filmes.model.Resultado;
import br.edu.fatecpg.filmes.service.ConsomeApi;
import br.edu.fatecpg.filmes.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FilmesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Scanner scan = new Scanner(System.in);

		boolean i = true;

		while (i) {
			System.out.println("Digite uma opção" + "\n" +
					"1 - Buscar Dados de Filme ou Série" + " \n" +
					"2 - Fechar App");

			int opc = scan.nextInt();
			scan.nextLine();//senao pega um espaço

			switch (opc) {
				case 1:

					System.out.println("Digite o nome do filme ou série:");
					String filme = scan.nextLine();
					if (filme!=null) {
						ConverteDado conversor = new ConverteDado();
						String json = ConsomeApi.obterDados(filme);
						Resultado jsonTratado = conversor.obterDado(json, Resultado.class);
						System.out.println(jsonTratado);

					};
					break;

				case 2:
					i=false;
					break;

			}
		}

	}
}
