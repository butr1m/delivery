package com.butr1m.delivery.repository;

import com.butr1m.delivery.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
