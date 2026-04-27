package dreamdev.moniepoint.dreamorderservice.repository;

import dreamdev.moniepoint.dreamorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
