package webclient.backend.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webclient.backend.model.Clients;
import webclient.backend.repositories.ClientsRepository;
import webclient.backend.service.ClientsService;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public Clients save(Clients student) {
        return null;
    }

    @Override
    public Clients update(Clients student) {
        return null;
    }

    @Override
    public Clients get(Long id) {
        return null;
    }

    @Override
    public void delete(Clients student) {

    }
}
