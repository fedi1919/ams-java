package com.epi.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.epi.ams.entities.Provider;
@
        Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
