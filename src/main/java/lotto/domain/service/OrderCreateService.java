package lotto.domain.service;

import lotto.domain.entity.Order;

public class OrderCreateService {
    public Order create(int property) {
        return new Order(property);
    }
}
