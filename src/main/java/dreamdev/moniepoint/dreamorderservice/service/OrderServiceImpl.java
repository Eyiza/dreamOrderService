package dreamdev.moniepoint.dreamorderservice.service;

import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequest;
import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequestItem;
import dreamdev.moniepoint.dreamorderservice.dto.response.PlaceOrderResponse;
import dreamdev.moniepoint.dreamorderservice.enums.Currency;
import dreamdev.moniepoint.dreamorderservice.enums.OrderStatus;
import dreamdev.moniepoint.dreamorderservice.model.Order;
import dreamdev.moniepoint.dreamorderservice.model.ShippingAddress;
import dreamdev.moniepoint.dreamorderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (PlaceOrderRequestItem item : placeOrderRequest.getItems()){
            BigDecimal price = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalPrice = totalPrice.add(price);
        }

        Order order = modelMapper.map(placeOrderRequest, Order.class);
        order.setTotalAmount(totalPrice);
        order.setStatus(OrderStatus.RESERVED);

        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, PlaceOrderResponse.class);
    }
}
