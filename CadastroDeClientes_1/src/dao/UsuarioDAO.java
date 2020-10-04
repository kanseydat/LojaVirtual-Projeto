
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author Paulo
 */
public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void insert(Usuario nome) throws SQLException{         
            
            String sql = "insert into usuario(nome,senha,cpf) values('"+nome.getNome() +"','"+ nome.getSenha() +"','"+nome.getCpf()+"');";            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();            
                  
                    
    }


    public boolean autenticarUsuario(Usuario nome) throws SQLException {
        String sql = "select * from usuario where nome = '"+nome.getNome()+"' and senha = '"+nome.getSenha()+"';";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();       
        
        return resultSet.next();
    }

   
   

    
    
}
