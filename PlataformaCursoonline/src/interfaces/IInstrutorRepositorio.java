package interfaces;

import java.util.ArrayList;
import entidades.Instrutor;

public interface IInstrutorRepositorio{
    void adicionarInstrutor(int id, String nome, String areaDeEspecializacao, int anosDeExperiencia); 
    void listarInstrutores();       
    ArrayList<Instrutor> listarTodos();   
    void alterarInstrutor(int id, String nome, String areaDeEspecializacao, int anosDeExperiencia); 
    void excluirInstrutor(int id);            
    
}
