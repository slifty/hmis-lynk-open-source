package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2016.Client;

public interface ClientDao extends ParentDao {
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2016.Client client);
	
	Client createClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);
	Client getClientById(UUID clientId);
	List<Client> getAllClients(String username,Integer startIndex, Integer maxItems);
	long getClientsCount(String projectGroupCode);
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientByDedupCliendId(UUID id,String projectGroupCode);
}