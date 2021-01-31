package com.bootsecurity.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootsecurity.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
