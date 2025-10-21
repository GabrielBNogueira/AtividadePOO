package com.atividade.biblioteca.controller;

import com.atividade.biblioteca.entity.Livro;
import com.atividade.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;
    @GetMapping
    public List <Livro> listar (){
        return livroService.listarTodos();
    }

    @PostMapping
    public Livro criar (@RequestBody Livro livro){
        return livroService.criar(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Livro> buscarPorId (@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Livro> atualizar (@PathVariable Long id, @RequestBody Livro dados){
        return livroService.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar (@PathVariable Long id){
        return livroService.deletar(id);
    }
}