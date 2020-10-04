
package Controlador;

import dao.Conexão;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;

/**
 *
 * @author Paulo
 */
public class FormCadastro {
    private Cadastro view;

    public FormCadastro(Cadastro view) {
        this.view = view;
    }
    
    public void usuarioSalvo(){
        
        
        
        String nome = view.getTxtNome().getText();
        String senha = view.getTxtSenha().getText();
        String cpf = view.getTxtCPF().getText();
        
        Usuario usuario = new Usuario(nome,senha,cpf);
        try {
            Connection conexao = new Conexão().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
