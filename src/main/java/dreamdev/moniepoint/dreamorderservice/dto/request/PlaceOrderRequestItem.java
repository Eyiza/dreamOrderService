package dreamdev.moniepoint.dreamorderservice.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PlaceOrderRequestItem {
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;
}
