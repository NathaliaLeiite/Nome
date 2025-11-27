package com.ufg.trabalhoPOO.config;

import com.ufg.trabalhoPOO.model.*;
import com. ufg.trabalhoPOO.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDados {

    @Bean
    CommandLineRunner executarCarga(
            UsuarioRepository usuarioRepo,
            LivroRepository livroRepo,
            AvaliacaoRepository avaliacaoRepo,
            AmizadeRepository amizadeRepo) {
        
        return args -> {
            // Só cadastra se o banco estiver vazio
            if (usuarioRepo.count() > 0) {
                return;
            }

            System.out.println("--- INICIANDO CARGA DE DADOS AUTOMÁTICA ---");

            // 1. Cria os Usuários
            Usuario u1 = new Usuario("Beatriz", "bia@ufg.br", "123", "Suspense");
            Usuario u2 = new Usuario("Carla", "carla@ufg.br", "123", "Fantasia");
            
            usuarioRepo.save(u1);
            usuarioRepo.save(u2);
            System.out.println("✅ Usuários criados: Beatriz e Carla");
            // 2. Criar Livro
            Livro l1 = new Livro("978-8535902778", "Dom Casmurro", "Machado de Assis", "Romance", 1899);
            Livro l2 = new Livro("978-0545010221", "Harry Potter", "J.K. Rowling", "Fantasia", 2000);
            
            livroRepo.save(l1);
            livroRepo.save(l2);
            System.out.println("✅ Livros criados: Dom Casmurro e Harry Potter");

            // 3. Criar Avaliação (Beatriz avalia Dom Casmurro)
            Avaliacao a1 = new Avaliacao();
            a1.setUsuario(u1);
            a1.setLivro(l1);
            a1.setNota(5);
            a1.setComentario("Capitu traiu ou não traiu? Eis a questão.");
            
            avaliacaoRepo.save(a1);
            System.out.println("✅ Avaliação criada");

            // 4. Criar Amizade (entre Beatriz e Carla)
            Amizade amizade = new Amizade();
            amizade.setUsuario1(u1);
            amizade.setUsuario2(u2);
            amizade.setStatus("ACEITA");
            
            amizadeRepo.save(amizade);
            System.out.println("✅ Amizade criada");

            System.out.println("--- CARGA DE DADOS FINALIZADA COM SUCESSO ---");
        };
    }

}
