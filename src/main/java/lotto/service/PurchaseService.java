package lotto.service;

import lotto.model.Purchase;

public class PurchaseService {

    public Purchase getPurchaseIfValid(String input) {
        try {
            return new Purchase(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
