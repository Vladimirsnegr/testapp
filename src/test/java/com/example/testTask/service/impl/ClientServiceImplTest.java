package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Client;
import com.example.testTask.entity.OrganizationForm;
import com.example.testTask.rep.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest extends GeneralTest<Client> {
    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
        Specifications<Client> clientSpecifications = Mockito.mock(Specifications.class);
        ClientServiceImpl clientService = Mockito.spy(new ClientServiceImpl(clientRepository,clientSpecifications));

        super.repository=clientRepository;
        super.specifications=clientSpecifications;
        super.service=clientService;
    }

    @Override
    protected List<Client> getObjects() {
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("name1");
        client1.setShortName("shortName1");
        client1.setAddress("address1");

        OrganizationForm form1 = new OrganizationForm();
        form1.setId(1L);
        form1.setName("name1");
        client1.setOrganizationForm(form1);

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("name2");
        client2.setShortName("shortName2");
        client2.setAddress("address2");

        OrganizationForm form2 = new OrganizationForm();
        form2.setId(2L);
        form2.setName("name2");
        client2.setOrganizationForm(form2);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        return clients;
    }

    @Override
    protected Client getObject() {
        Client client = new Client();
        client.setId(1L);
        client.setName("name");
        client.setShortName("shortName");
        client.setAddress("address");

        OrganizationForm form = new OrganizationForm();
        form.setId(1L);
        form.setName("name");
        client.setOrganizationForm(form);

        return client;
    }

    @Override
    protected Client updateObject(Client object) {
        object.setName("updated"+object.getName());
        object.setShortName("updated"+object.getShortName());
        object.setAddress("updated"+object.getAddress());

        OrganizationForm form = new OrganizationForm();
        form.setId(2L);
        form.setName("name2");
        object.setOrganizationForm(form);
        return object;
    }
}
