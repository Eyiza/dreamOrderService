package dreamdev.moniepoint.dreamorderservice.repository;

import dreamdev.moniepoint.dreamorderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
