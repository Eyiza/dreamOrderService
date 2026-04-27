package dreamdev.moniepoint.dreamorderservice.dto.response;

import dreamdev.moniepoint.dreamorderservice.enums.Currency;
import dreamdev.moniepoint.dreamorderservice.enums.OrderStatus;
import dreamdev.moniepoint.dreamorderservice.enums.PaymentMethod;
import dreamdev.moniepoint.dreamorderservice.model.ShippingAddress;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PlaceOrderResponse {
    private String id;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private Currency currency;
    private PaymentMethod paymentMethod;
    private ShippingAddress shippingAddress;
    private List<OrderItemResponse> items;
    private LocalDateTime createdAt;
}
