package art.backend.dao;

import art.backend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<Location, Integer> {
}
