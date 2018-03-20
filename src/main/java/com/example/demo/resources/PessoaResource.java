package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Pessoa;
import com.example.demo.services.PessoaService;


@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource
{	
	@Autowired
	private PessoaService pessoaService;

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> listar() {
        return this.pessoaService.listaPessoa();
    }    
    

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public Pessoa getById(@PathVariable Integer id) {
        return this.pessoaService.getById(id);
    }

    @RequestMapping(value = "/pessoa/{nome}/nome", method = RequestMethod.GET)
    public List<Pessoa> listaPaginada(@PathVariable String nome) {
        return this.pessoaService.buscaPorNome(nome);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return this.pessoaService.salvarPessoa(pessoa);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
    public Pessoa editar(@RequestBody Pessoa pessoa) {
        return this.pessoaService.salvarPessoa(pessoa);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Integer id) {
        this.pessoaService.deletePessoa(id);
    }
}