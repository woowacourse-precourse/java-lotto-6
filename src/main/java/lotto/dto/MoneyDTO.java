package lotto.dto;

public class MoneyDTO {
    private final Integer amount;
    private final Float returnRate;

    public MoneyDTO(Integer amount) {
        this(amount, 0F);
    }

    public MoneyDTO(Integer amount, Float returnRate) {
        this.amount = amount;
        this.returnRate = returnRate;
    }

    public Integer getAmount() {
        return amount;
    }

    public Float getReturnRate() {
        return returnRate;
    }
}
