package br.com.locadora.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.locadora.generic.Conexao;
public class ClienteDao {

	private Conexao conexao;

	private Statement stmt;

	public ClienteDao() {
		conexao = new Conexao();

	}

	public void inserir(Cliente cliente) {
		try {

			conexao = new Conexao();
			stmt = (Statement) conexao.getConn().createStatement();
			String sql = "INSERT INTO CLIENTE(CLIENTE_NOME,  CLIENTE_RG, CLIENTE_CPF,"
					+ "	CLIENTE_DATA_NASCIMENTO,  CLIENTE_ENDERECO,  "
					+ "	CLIENTE_BAIRRO,  CLIENTE_CIDADE,  CLIENTE_ESTADO, CLIENTE_TELEFONE, "
					+ "	CLIENTE_EMAIL,  CLIENTE_NOME_MAE,  "
					+ "	CLIENTE_NOME_PAI, CLIENTE_DEPENDENTES) ";
			sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexao.getConn()
					.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getRg());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getDataNasc());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getBairro());
			preparedStatement.setString(7, cliente.getCidade());
			preparedStatement.setString(8, cliente.getEstado());
			preparedStatement.setString(9, cliente.getTelefone());
			preparedStatement.setString(10, cliente.getEmail());
			preparedStatement.setString(11, cliente.getMae());
			preparedStatement.setString(12, cliente.getPai());
			preparedStatement.setInt(13, cliente.getDependentes());
			preparedStatement.executeUpdate();
			System.out.print(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
	}

	public void alterar(Cliente cliente) {
		try {
			conexao = new Conexao();
			String sql = "UPDATE CLIENTE SET CLIENTE_NOME = ?,"
					+ " CLIENTE_RG = ? , CLIENTE_CPF = ?,"
					+ "	CLIENTE_DATA_NASCIMENTO = ?,  CLIENTE_ENDERECO = ?,"
					+ "	CLIENTE_BAIRRO = ?,  CLIENTE_CIDADE = ?,  CLIENTE_ESTADO = ?," 
					+ " CLIENTE_TELEFONE = ?, CLIENTE_EMAIL = ?,  CLIENTE_NOME_MAE = ?,  "
					+ "	CLIENTE_NOME_PAI = ?, CLIENTE_DEPENDENTES = ?"
					+ " WHERE CLIENTE_CODIGO = ?";
			PreparedStatement preparedStatement = conexao.getConn()
					.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getRg());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getDataNasc());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getBairro());
			preparedStatement.setString(7, cliente.getCidade());
			preparedStatement.setString(8, cliente.getEstado());
			preparedStatement.setString(9, cliente.getTelefone());
			preparedStatement.setString(10, cliente.getEmail());
			preparedStatement.setString(11, cliente.getMae());
			preparedStatement.setString(12, cliente.getPai());
			preparedStatement.setInt(13, cliente.getDependentes());
			preparedStatement.setInt(14, cliente.getCodigo());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
	}
	
	public void remover(Cliente cliente){
		try {
			conexao = new Conexao();
			String sql = "DELETE FROM CLIENTE WHERE CLIENTE_CODIGO = ?";
			PreparedStatement preparedStatement = conexao.getConn().
					prepareStatement(sql);
			preparedStatement.setInt(1, cliente.getCodigo());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conexao.fecharConexao();
		}
	}
	
	public List<Cliente> listaTudo(){
		conexao = new Conexao();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			stmt = (Statement) conexao.getConn().createStatement();
			String sql = "SELECT * FROM CLIENTE";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("CLIENTE_CODIGO"));
				cliente.setNome(rs.getString("CLIENTE_NOME"));
				cliente.setRg(rs.getString("CLIENTE_RG"));
				cliente.setCpf(rs.getString("CLIENTE_CPF"));
				cliente.setDataNasc(rs.getString("CLIENTE_DATA_NASCIMENTO"));
				cliente.setEndereco(rs.getString("CLIENTE_ENDERECO"));
				cliente.setBairro(rs.getString("CLIENTE_BAIRRO"));
				cliente.setCidade(rs.getString("CLIENTE_CIDADE"));
				cliente.setEstado(rs.getString("CLIENTE_ESTADO"));
				cliente.setTelefone(rs.getString("CLIENTE_TELEFONE"));
				cliente.setEmail(rs.getString("CLIENTE_EMAIL"));
				cliente.setMae(rs.getString("CLIENTE_NOME_MAE"));
				cliente.setPai(rs.getString("CLIENTE_NOME_PAI"));
				cliente.setDependentes(rs.getInt("CLIENTE_DEPENDENTES"));
				clientes.add(cliente);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public Cliente listaPorId(Integer codigo){
		conexao = new Conexao();
		Cliente cliente = new Cliente();
		try {
			String sql = "SELECT * FROM CLIENTE WHERE CLIENTE_CODIGO = ?";
			PreparedStatement preparedStatement = conexao.getConn()
					.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				cliente.setCodigo(rs.getInt("CLIENTE_CODIGO"));
				cliente.setNome(rs.getString("CLIENTE_NOME"));
				cliente.setRg(rs.getString("CLIENTE_RG"));
				cliente.setCpf(rs.getString("CLIENTE_CPF"));
				cliente.setDataNasc(rs.getString("CLIENTE_DATA_NASCIMENTO"));
				cliente.setEndereco(rs.getString("CLIENTE_ENDERECO"));
				cliente.setBairro(rs.getString("CLIENTE_BAIRRO"));
				cliente.setCidade(rs.getString("CLIENTE_CIDADE"));
				cliente.setEstado(rs.getString("CLIENTE_ESTADO"));
				cliente.setTelefone(rs.getString("CLIENTE_TELEFONE"));
				cliente.setEmail(rs.getString("CLIENTE_EMAIL"));
				cliente.setMae(rs.getString("CLIENTE_NOME_MAE"));
				cliente.setPai(rs.getString("CLIENTE_NOME_PAI"));
				cliente.setDependentes(rs.getInt("CLIENTE_DEPENDENTES"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
}