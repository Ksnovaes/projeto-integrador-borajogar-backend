package com.ksnovaes.borajogar.repositories;

import com.ksnovaes.borajogar.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
