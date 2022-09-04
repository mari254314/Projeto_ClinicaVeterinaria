package model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private int id_cliente = 1;

    public List<Cliente> create(String nome, String end, String email, String cep, String tel, int id_animal) {
        Cliente clientes = new Cliente(id_cliente, nome, end, email, cep, tel, id_animal);
        this.clientes.add(clientes);
        id_cliente++;
        return this.clientes;
    }

    public List<Cliente> retrieveAll() {
        return this.clientes;
    }

    public List<Cliente> retrieveId(int id) {
        return (List<Cliente>) this.clientes.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String nome, String end, String email, String cep, String tel) {
        int index = 0;

        for (Cliente clientes:this.clientes) {
            if (clientes.getId() == id) {
                Cliente cliente_update = this.clientes.get(index);
                cliente_update.setNome(nome);
                cliente_update.setEnd(end);
                cliente_update.setEmail(email);
                cliente_update.setCep(cep);
                cliente_update.setTel(tel);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Cliente cliente:this.clientes) {
            if (cliente.getId() == id) {
                this.clientes.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }

}