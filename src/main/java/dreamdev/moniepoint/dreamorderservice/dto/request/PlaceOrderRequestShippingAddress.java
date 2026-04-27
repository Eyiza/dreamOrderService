package dreamdev.moniepoint.dreamorderservice.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlaceOrderRequestShippingAddress {
    private String street;
    private String city;
    private String state;
    private String country;
}

