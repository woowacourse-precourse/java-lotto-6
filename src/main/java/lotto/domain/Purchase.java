package lotto.domain;


import static lotto.validate.InputValidation.THOUSAND;

public class Purchase {
    private int quantity;
    public Purchase(int quantity) {
        this.quantity = quantity;
    }

    public void calculateQuantity(String purchaseAmount) {
        quantity = Integer.parseInt(purchaseAmount) / THOUSAND;
    }

    public int getQuantity() {
        return quantity;
    }

}
