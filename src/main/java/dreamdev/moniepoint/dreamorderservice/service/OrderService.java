package dreamdev.moniepoint.dreamorderservice.service;

import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequest;
import dreamdev.moniepoint.dreamorderservice.dto.response.PlaceOrderResponse;

public interface OrderService {
    PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}
