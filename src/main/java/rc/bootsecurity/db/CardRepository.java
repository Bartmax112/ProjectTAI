package rc.bootsecurity.db;

import org.springframework.data.jpa.repository.JpaRepository;
import rc.bootsecurity.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
