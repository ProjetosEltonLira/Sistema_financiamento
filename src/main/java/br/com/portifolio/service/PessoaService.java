package br.com.portifolio.service;

import br.com.portifolio.model.Dao.DaoFactory;
import br.com.portifolio.model.Dao.PessoaDao;
import br.com.portifolio.model.db.DbException;
import br.com.portifolio.model.entities.Pessoa;

public class PessoaService {


    static PessoaDao pessoaDao = DaoFactory.createPessoaDAO();


    public void cadastrarPessoa(Pessoa pessoa){

        if(pessoaDao.findById(pessoa.getId()) == null) {
            pessoaDao.insert(pessoa);
        }
        else{
            System.err.println("Já existe um cliente cadastrado para esse cpf/cnpj,segue dados abaixo:");
            System.out.println(pessoa);
        }
    }

    public static Pessoa buscarPessoa(String id) {
        return pessoaDao.findById(id);
    }

    public void atualizarPessoa(Pessoa pessoa){
       try {
           pessoaDao.update(pessoa);
       }catch (DbException e){
           throw new DbException(e.getMessage());
       }
    }

    public static void deletarPessoa(String id){
        try {
            pessoaDao.deleteById(id);
        }
        catch (DbException e){
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirListaPessoa() {
        System.out.println("+++++++ INICIO LISTA DE CLIENTES +++++++");
        pessoaDao.findAll().forEach(System.out::println);
        System.out.println("++++++++++ FIM LISTA DE CLIENTES +++++++");
    }
}
