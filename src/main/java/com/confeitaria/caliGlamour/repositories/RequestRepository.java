package com.confeitaria.caliGlamour.repositories;

import com.confeitaria.caliGlamour.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
