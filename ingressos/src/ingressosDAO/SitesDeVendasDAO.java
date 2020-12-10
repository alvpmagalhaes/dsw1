package ingressosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ingressosModel.SitesDeVenda;
import util.DbUtil;

import java.util.HashMap;
import java.util.Map;


public class SitesDeVendasDAO {

    private final Connection connection;

    public SitesDeVendasDAO() {
        connection = DbUtil.getConnection();
    }

    public void addSitesDeVenda(SitesDeVenda user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sitesdevenda(email,senha,endereco,nome,telefone) values (?, ?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setString(3, user.getEndereco());
            preparedStatement.setString(4, user.getNome());
            preparedStatement.setString(5, user.getTelefone());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSitesDeVenda(String nome) {
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

    public void updateSitesDeVenda(SitesDeVenda user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set nome=?, endereco=?, telefone=?, email=?, senha=?" +
                            "where nome=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getEndereco());
            preparedStatement.setString(3, user.getTelefone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(3, user.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SitesDeVenda> getAllUsers() {
        List<SitesDeVenda> listadesites = new ArrayList<SitesDeVenda>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                SitesDeVenda sitesdevenda = new SitesDeVenda();
                sitesdevenda.setNome(rs.getString("nome"));
                sitesdevenda.setEndereco(rs.getString("endereco"));
                sitesdevenda.setEmail(rs.getString("email"));
                listadesites.add(sitesdevenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listadesites;
    }

    public SitesDeVenda getUserByNome(String nome) {
        SitesDeVenda user = new SitesDeVenda();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where nome=?");
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setEndereco(rs.getString("endereco"));
                user.setEmail(rs.getString("email"));
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
       
    }
    
    private final static Map<String, SitesDeVenda> SITESDEVENDA = new HashMap<>();
	static {
		SITESDEVENDA.put("pedro.apolloni@estudante.ufscar.br", new SitesDeVenda());
	}

	public SitesDeVenda buscaPorEmailESenha(String email, String senha) {
		if (!SITESDEVENDA.containsKey(email))
			return null;

		SitesDeVenda sitesdevenda = SITESDEVENDA.get(email);
		if (sitesdevenda.getSenha().equals(senha))
			return sitesdevenda;
		
		return null;
	}
}