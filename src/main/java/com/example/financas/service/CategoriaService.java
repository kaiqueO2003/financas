package com.example.financas.service;

import com.example.financas.domain.Categoria;
import com.example.financas.domain.DTO.CategoriaDTO;
import com.example.financas.repository.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Categoria insert(Categoria obj){
        return repo.save(obj);
    }

    public void delete (Long id){
        repo.deleteById(id);
    }
    public Categoria update(Categoria obj){
        Categoria newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Categoria newObj, Categoria obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria (objDto.getId(), objDto.getNome(), objDto.getDescricao());
    }

}
