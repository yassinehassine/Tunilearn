package Tunilearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Tunilearn.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}