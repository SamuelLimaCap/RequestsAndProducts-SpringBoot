package com.confeitaria.caliGlamour.repositories;

import com.confeitaria.caliGlamour.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
