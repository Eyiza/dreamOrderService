package dreamdev.moniepoint.dreamorderservice.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class ShippingAddress {
    private String street;
    private String city;
    private String state;
    private String country;
}
