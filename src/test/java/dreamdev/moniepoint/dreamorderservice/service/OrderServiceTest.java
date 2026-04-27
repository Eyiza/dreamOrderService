package dreamdev.moniepoint.dreamorderservice.service;


import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequest;
import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequestItem;
import dreamdev.moniepoint.dreamorderservice.dto.request.PlaceOrderRequestShippingAddress;
import dreamdev.moniepoint.dreamorderservice.dto.response.PlaceOrderResponse;
import dreamdev.moniepoint.dreamorderservice.enums.OrderStatus;
import dreamdev.moniepoint.dreamorderservice.enums.PaymentMethod;
import dreamdev.moniepoint.dreamorderservice.model.Order;
import dreamdev.moniepoint.dreamorderservice.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void placeOrderTest(){
        // Set Item Details
        PlaceOrderRequestItem placeOrderRequestItem = new PlaceOrderRequestItem();
        placeOrderRequestItem.setProductId("productId");
        placeOrderRequestItem.setQuantity(2);
        placeOrderRequestItem.setUnitPrice(new BigDecimal(45000));

        PlaceOrderRequestItem placeOrderRequestItem2 = new PlaceOrderRequestItem();
        placeOrderRequestItem2.setProductId("productId2");
        placeOrderRequestItem2.setQuantity(3);
        placeOrderRequestItem2.setUnitPrice(new BigDecimal(9000));

        // Set Shipping Address Details
        PlaceOrderRequestShippingAddress placeOrderRequestShippingAddress = new PlaceOrderRequestShippingAddress();
        placeOrderRequestShippingAddress.setStreet("2 Amusa Street");
        placeOrderRequestShippingAddress.setCity("Jibowu");
        placeOrderRequestShippingAddress.setState("Lagos");
        placeOrderRequestShippingAddress.setCountry("Nigeria");

        // Set Full Request
        PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
        placeOrderRequest.setBuyerId("buyer");
        placeOrderRequest.setItems(List.of(placeOrderRequestItem, placeOrderRequestItem2));
        placeOrderRequest.setShippingAddress(placeOrderRequestShippingAddress);
        placeOrderRequest.setPaymentMethod(PaymentMethod.WALLET);

        Order savedOrder = new Order();
        savedOrder.setId("orderId");
        savedOrder.setStatus(OrderStatus.PENDING);
        savedOrder.setTotalAmount(new BigDecimal("117000"));

        PlaceOrderResponse placeOrderResponse = new PlaceOrderResponse();
        placeOrderResponse.setId(savedOrder.getId());
        placeOrderResponse.setStatus(OrderStatus.PENDING);
        placeOrderResponse.setTotalAmount(new BigDecimal("117000"));

        when(modelMapper.map(placeOrderRequest, Order.class)).thenReturn(new Order());
        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);
        when(modelMapper.map(savedOrder, PlaceOrderResponse.class)).thenReturn(placeOrderResponse);

        PlaceOrderResponse placedOrder = orderService.placeOrder(placeOrderRequest);

        Assertions.assertThat(placedOrder).isNotNull();
    }
}
