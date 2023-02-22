package com.euromix.demo.DAO;

import com.euromix.demo.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesDAO {

    private static String INSERT = "insert into cliente (nome) values (?) ";
    private static String UPDATE = "update cliente set nome = ? where id = ? ";
    private static String DELETE = "delete from cliente where id = ? ";
    private static String SELECT_ALL_CLIENTES = "select * from cliente";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }
    public Cliente update(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente) {
        jdbcTemplate.update(DELETE, new Object[]{cliente.getId()});

    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL_CLIENTES, getRowMapperClente());
    }
  public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL_CLIENTES.concat(" where nome like ? "),new Object[]{"%"+ nome + "%"}, getRowMapperClente());
    }

    private RowMapper<Cliente> getRowMapperClente() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }
}

