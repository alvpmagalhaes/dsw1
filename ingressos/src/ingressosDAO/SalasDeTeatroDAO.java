package ingressosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ingressosModel.SalasDeTeatro;
import ingressosModel.SitesDeVenda;
import util.DbUtil;

import java.util.HashMap;
import java.util.Map;

public class SalasDeTeatroDAO {
	
	private final Connection connection;

    public SalasDeTeatroDAO() {
        connection = DbUtil.getConnection();
    }

    public void addSalasDeTeatro(SalasDeTeatro sala) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into salasdeteatro(email,senha,cnpj,nome,cidade) values (?, ?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setString(3, sala.getCnpj());
            preparedStatement.setString(4, sala.getNome());
            preparedStatement.setString(5, sala.getCidade());
            preparedStatement.setString(1, sala.getEmail());
            preparedStatement.setString(2, sala.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSalasDeTeatro(String nome) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where nome=?");
            // Parameters start with 1
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSalasDeTeatro(SalasDeTeatro sala) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set nome=?, cidade=?, cnpj=?, email=?, senha=?" +
                            "where nome=?");
            // Parameters start with 1
            preparedStatement.setString(1, sala.getNome());
            preparedStatement.setString(2, sala.getCidade());
            preparedStatement.setString(3, sala.getCnpj());
            preparedStatement.setString(3, sala.getEmail());
            preparedStatement.setString(3, sala.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SalasDeTeatro> getAllUsers() {
        List<SalasDeTeatro> listadesalas = new ArrayList<SalasDeTeatro>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from salas");
            while (rs.next()) {
                SalasDeTeatro salasdeteatro = new SalasDeTeatro();
                salasdeteatro.setNome(rs.getString("nome"));
                salasdeteatro.setCidade(rs.getString("cidade"));
                salasdeteatro.setEmail(rs.getString("email"));
                listadesalas.add(salasdeteatro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listadesalas;
    }

    public SalasDeTeatro getUserByNome(String nome) {
        SalasDeTeatro sala = new SalasDeTeatro();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from salas where nome=?");
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                sala.setNome(rs.getString("nome"));
                sala.setCidade(rs.getString("cidade"));
                sala.setEmail(rs.getString("email"));
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sala;
    }
    
    private final static Map<String, SalasDeTeatro> SALASDETEATRO = new HashMap<>();
	static {
		SALASDETEATRO.put("pedro.apolloni@estudante.ufscar.br", new SalasDeTeatro());
	}

	public SalasDeTeatro buscaPorEmailESenha(String email, String senha) {
		if (!SALASDETEATRO.containsKey(email))
			return null;

		SalasDeTeatro salasdeteatro = SALASDETEATRO.get(email);
		if (salasdeteatro.getSenha().equals(senha))
			return salasdeteatro;
		
		return null;
	}

}
