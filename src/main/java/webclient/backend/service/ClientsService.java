package webclient.backend.service;

import webclient.backend.model.Clients;

public interface ClientsService {

    public Clients save(Clients student);
    public Clients update(Clients student);
    public Clients get(Long id);
    public void delete(Clients student);

}
