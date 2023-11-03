package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Lotto> lottos;
    private int payment;
    private int price;

    public Customer(int payment) {
        this.lottos = new ArrayList<>();
        this.payment = payment;
        this.price = 0;
    }


}
