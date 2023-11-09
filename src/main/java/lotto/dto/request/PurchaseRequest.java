package lotto.dto.request;

public class PurchaseRequest {

    private final String money;

    public PurchaseRequest(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}