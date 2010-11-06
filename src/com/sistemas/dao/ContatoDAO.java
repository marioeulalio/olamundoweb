package com.sistemas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sistemas.entidades.Contato;

public class ContatoDAO {
	
	private Connection conn;
	
	public ContatoDAO() {
		conn = ConnectionFactory.getConnection();
	}	
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos(nome, email,endereco,dataNascimento) values (?,?,?,?)";
		
		try {
			
			String dataFormatadaStr = null;
			
			dataFormatadaStr = new SimpleDateFormat("yyyy-MM-dd").format(contato.getDataNascimento());
			
			java.sql.Date dataSql = java.sql.Date.valueOf(dataFormatadaStr);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			stmt.setString(3, contato.getEmail());
			stmt.setDate(4, dataSql);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato getById(Integer id){
		String sql = "select * from contatos where id=?";
		PreparedStatement stmt;
		ResultSet rs;
		Contato c1 = new Contato();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if (rs.next()){
				
				
				Long contato_id = new Long(rs.getInt("id"));
				
				c1.setId(contato_id);
				c1.setNome(rs.getString("nome"));
				c1.setEmail(rs.getString("email"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c1;
	}
	
	public void excluir(Contato contato){
		String sql = "delete from contatos where id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public List<Contato> getAll(){
		String sql = "select * from contatos";
		List<Contato> listaContatos = new ArrayList<Contato>();
		
		PreparedStatement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()){
				Contato c1 = new Contato();
				c1.setNome(rs.getString("nome"));
				c1.setEmail(rs.getString("email"));
				
				listaContatos.add(c1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaContatos;
		
	}
	
	
}
