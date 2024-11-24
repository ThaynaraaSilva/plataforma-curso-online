package repositorio;

import interfaces.ICursoRepositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entidades.Curso;
import entidades.CursoOnline;
import entidades.CursoPresencial;
import entidades.Aluno;
import enums.TipoCurso;
import java.util.UUID;
import util.ConnectionSingleton;

public class CursoRepositorio implements ICursoRepositorio {

    private List<Curso> cursos = new ArrayList<>();

    @Override
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public Curso buscarCursoPorId(String id) {
    	String sql = "SELECT * FROM curso WHERE id = ?";
        Curso cursoEncontrado = null; 

        try (Connection conexao = ConnectionSingleton.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                TipoCurso tipo = TipoCurso.valueOf(rs.getString("tipo"));
                if (tipo == TipoCurso.PRESENCIAL) {
                    cursoEncontrado = new CursoPresencial(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getInt("ano_criacao"),
                        rs.getInt("duracao_horas"),
                        rs.getDouble("preco"),
                        tipo,
                        rs.getString("local_aula"), 
                        rs.getInt("capacidade_alunos") 
                    );
                } else {
                    cursoEncontrado = new CursoOnline(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getInt("ano_criacao"),
                        rs.getInt("duracao_horas"),
                        rs.getDouble("preco"),
                        tipo
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar o curso por ID.", e);
        }
        return cursoEncontrado; 
    }
    	 
    

    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO curso (id, titulo, descricao, ano_criacao, duracao_horas, preco, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionSingleton.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, curso.getId() != null ? curso.getId() : UUID.randomUUID().toString());
            stmt.setString(2, curso.getTitulo());
            stmt.setString(3, curso.getDescricao());
            stmt.setInt(4, curso.getAnoCriacao());
            stmt.setInt(5, curso.getDuracaoHoras());
            stmt.setDouble(6, curso.getPreco());
            stmt.setString(7, curso.getTipo().name());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o curso.", e);
        }
    }

    @Override
    public void alterar(Curso curso) {
        String sql = "UPDATE curso SET titulo = ?, descricao = ?, ano_criacao = ?, duracao_horas = ?, preco = ?, tipo = ? WHERE id = ?";

        try (Connection conexao = ConnectionSingleton.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, curso.getTitulo());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getAnoCriacao());
            stmt.setInt(4, curso.getDuracaoHoras());
            stmt.setDouble(5, curso.getPreco());
            stmt.setString(6, curso.getTipo().name());
            stmt.setString(7, curso.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao alterar o curso.", e);
        }
    }

    @Override
    public void removerCurso(String id) {
        String sql = "DELETE FROM curso WHERE id = ?";

        try (Connection conexao = ConnectionSingleton.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir o curso.", e);
        }
    }

    @Override
    public List<Curso> listarCursos() {
    	 String sql = "SELECT * FROM curso";
    	    List<Curso> cursos = new ArrayList<>();

    	    try (Connection conexao = ConnectionSingleton.getInstance().getConnection();
    	         Statement stmt = conexao.createStatement()) {

    	        ResultSet rs = stmt.executeQuery(sql);

    	        while (rs.next()) {
    	            String id = rs.getString("id");
    	            String titulo = rs.getString("titulo");
    	            String descricao = rs.getString("descricao");
    	            int anoCriacao = rs.getInt("ano_criacao");
    	            int duracaoHoras = rs.getInt("duracao_horas");
    	            double preco = rs.getDouble("preco");
    	            TipoCurso tipo = TipoCurso.valueOf(rs.getString("tipo"));

    	            Curso curso;
    	            if (tipo == TipoCurso.PRESENCIAL) {
    	                curso = new CursoPresencial(id, titulo, descricao, anoCriacao, duracaoHoras, preco, tipo, "Local da aula", 20);
    	            } else {
    	                curso = new CursoOnline(id, titulo, descricao, anoCriacao, duracaoHoras, preco, tipo);
    	            }
    	            cursos.add(curso);
    	        }

    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        throw new RuntimeException("Erro ao listar todos os cursos.", e);
    	    }

    	    
    	    return cursos;
    }
    @Override
    public void inscreverAluno(Curso curso, Aluno aluno) {
      
    }

    @Override
    public boolean cancelarInscricao(Curso curso, Aluno aluno) {
               return false;
    }

    @Override
    public List<Aluno> listarAlunosInscritos(Curso curso) {
        return new ArrayList<>();
    }

	@Override
	public void atualizar(Curso cursoAtualizado) {
		
		 for (int i = 0; i < cursos.size(); i++) {
	            if (cursos.get(i).getId().equals(cursoAtualizado.getId())) {
	                cursos.set(i, cursoAtualizado);
	                break;
	            }
	        }
	}
	
}
