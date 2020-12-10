package ingressosDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ingressosModel.SalasDeTeatro;
import ingressosModel.SitesDeVenda;
import ingressosModel.Promo;
import util.DbUtil;

public class PromoDAO {

	private final Connection connection;

    public PromoDAO() {
        connection = DbUtil.getConnection();
    }

    public void addSitesDeVenda(Promo promo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into promo(endereco,cnpj,peca,preco,data) values (?, ?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, promo.getEndereco());
            preparedStatement.setString(2, promo.getCnpj());
            preparedStatement.setString(3, promo.getNomePeca());
            preparedStatement.setString(4, promo.getPreco());
            preparedStatement.setDate(5, (Date) promo.getDiahora());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 

    public List<Promo> getAllPromo() {
        List<Promo> listadepromo = new ArrayList<Promo>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from promos");
            while (rs.next()) {
                Promo promo = new promo();
                promo.setEndereco(rs.getString("endereco"));
                promo.setCnpj(rs.getString("cnpj"));
                promo.setPeca(rs.getString("nomePeca"));
                listadepromo.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listadepromo;
    }

	
	
	
	
	
}
