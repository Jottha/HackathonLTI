package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@Service
public class PessoaService
{	
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listaPessoa() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> buscaPorNome(String nome) {
        return pessoaRepository.findByNomeLikeIgnoreCase(nome);
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Integer id) {
        pessoaRepository.delete(id);
    }

    public Pessoa getById(Integer id) {
        return pessoaRepository.findOne(id);
    }
}
