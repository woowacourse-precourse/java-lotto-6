package lotto.controller.dto.request;

public class PurchaseDto {

    private int money;

    private PurchaseDto(Integer money) {
        this.money = money;
    }

    public static PurchaseDto from(String input) {
        return new PurchaseDto(Integer.parseInt(input));
    }

    public int getMoney() {
        return money;
    }
}
