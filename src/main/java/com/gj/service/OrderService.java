package com.gj.service;

import com.gj.pojo.Order;
import com.gj.pojo.dto.OrderDto;
import com.gj.repository.OrderRepository;
import com.gj.service.iservice.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order add(OrderDto order) {
        Order orderPojo = new Order();
        BeanUtils.copyProperties(order, orderPojo);
        return orderRepository.save(orderPojo);
    }

    @Override
    public Order get(Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("订单不存在"));
    }

    @Override
    public Order update(OrderDto order) {
        Order orderPojo = new Order();
        BeanUtils.copyProperties(order, orderPojo);
        return orderRepository.save(orderPojo);
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getStatus(Integer orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
    }

    @Override
    public Order finishOrder(Integer orderId, OrderDto order) {
        Order orderPojo = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("订单不存在"));
        orderPojo.setOrderStatus(order.getOrderStatus());
        orderPojo.setOrderDate(order.getOrderDate());
        return orderRepository.save(orderPojo);
    }

    @Override
    public Order updaterating(Integer orderId, OrderDto order) {
        Order orderPojo = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("订单不存在"));
        orderPojo.setOrderRating(order.getOrderRating());
        return orderRepository.save(orderPojo);
    }

    @Override
    public List<Order> getShopRating(Integer shopId) {
        List<Order> orderPojo = orderRepository.findByShopId(shopId);
        List<Order> result = new ArrayList<>();

        for (Order order : orderPojo) {
            if (order.getOrderStatus() == 2) {
                result.add(order);
            }
        }

        return result;
    }

}
