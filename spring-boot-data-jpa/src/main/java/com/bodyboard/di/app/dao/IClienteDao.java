/**
 * 
 */
package com.bodyboard.di.app.dao;

import java.util.List;

import com.bodyboard.di.app.models.Cliente;

/**
 * @author bodyboardss
 *
 */
public interface IClienteDao {
	public List<Cliente>  findAll();
	
	public void save(Cliente cliente);
}
