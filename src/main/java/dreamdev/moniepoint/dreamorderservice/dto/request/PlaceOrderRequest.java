package dreamdev.moniepoint.dreamorderservice.dto.request;

import dreamdev.moniepoint.dreamorderservice.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PlaceOrderRequest {
    private String buyerId;
    private List<PlaceOrderRequestItem> items;
    private PlaceOrderRequestShippingAddress shippingAddress;
    private PaymentMethod paymentMethod;
}