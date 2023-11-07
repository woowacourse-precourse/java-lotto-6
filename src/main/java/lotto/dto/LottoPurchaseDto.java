package lotto.dto;


public class LottoPurchaseDto {
    private int amount;
    private int quantity;

    public LottoPurchaseDto(int amount, int quantity) {
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }
}
