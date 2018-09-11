
package br.com.ambientinformatica.treinamento.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.treinamento.entidade.EnumPapelUsuario;
import br.com.ambientinformatica.treinamento.entidade.Usuario;
import br.com.ambientinformatica.treinamento.persistencia.UsuarioDao;
import br.com.ambientinformatica.util.UtilLog;

@Service("inicializadorSistema")
public class InicializadorSistema {

   @Autowired
   private UsuarioDao usuarioDao;

   @PostConstruct
   public void iniciar(){
      inicializarUsuarioAdmin();
   }

   private void inicializarUsuarioAdmin(){
      try {
         List<Usuario> usuarios = usuarioDao.listar();
         if(usuarios.isEmpty()){
            Usuario usu = new Usuario();
            usu.setNome("admin");
            usu.setLogin("11111111111");
            usu.setAtivo(true);
            usu.setSenhaNaoCriptografada("123456");
            usu.addPapel(EnumPapelUsuario.ADMIN);
            usu.addPapel(EnumPapelUsuario.USUARIO);
            usuarioDao.incluir(usu);
            UtilLog.getLog().info("*** USUÁRIO 11111111111 CRIADO com a senha 123456 ***");
         }
      } catch (Exception e) {
         UtilLog.getLog().error(e.getMessage(), e);
      }
   }

}
