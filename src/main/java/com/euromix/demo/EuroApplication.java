package com.euromix.demo;

import com.euromix.demo.DAO.ClientesDAO;
import com.euromix.demo.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EuroApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesDAO clientes) {
        return args -> {
            clientes.salvar(new Cliente("Weslley"));
            clientes.salvar(new Cliente("Bianca"));
            List<Cliente> todosClientes = clientes.obterTodos();

            System.out.println("Sem atualizar");
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado");
                clientes.update(c);
            });
            System.out.println("atualizado");
            todosClientes.forEach(System.out::println);
            System.out.println("Buscando");
            clientes.buscarPorNome("Bi").forEach(System.out::println);
            System.out.println("Deletar");
            clientes.buscarPorNome("Bi").forEach(c ->{
                clientes.deletar(c);
                System.out.println("Cliente " + c.getNome() + " Deletado com sucesso");
            });

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EuroApplication.class, args);
    }

}
