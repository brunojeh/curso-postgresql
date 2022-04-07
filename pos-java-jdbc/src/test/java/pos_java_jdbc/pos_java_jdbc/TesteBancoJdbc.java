package pos_java_jdbc.pos_java_jdbc;



import java.security.PublicKey;
import java.util.List;

import org.junit.Test;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("biricutico");
		userposjava.setEmail("biricutico@biricutico.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6L);
			
			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar () {
		try {
			
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscar(5L);
		
		objetoBanco.setNome("Nome mudado com o metodo atualizar");
		
		dao.atualizar(objetoBanco);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initdeletar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("11 99999-9999");
		telefone.setTipo("casa");
		telefone.setUsuario(10L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
	
	@Test
	public void testeCarregaFoneUser() {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(10L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------------------------------------------------------------------");
		}
		
	}
	
		@Test
		public void testeDeleteUserFone() {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deleteFonesPorUser(10L);
		}

	
}
