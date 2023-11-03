package lotto.enums;

public enum AmountEnum {
    MIN_VALUE(1000,"1,000"),
    MAX_VALUE(2147483000,"2,147,483,000"),
    ZERO_VALUE(0, "2,147,483,000");
    private final Integer numbers;
    private final String currencyForm;

    AmountEnum(Integer numbers, String currencyForm) {
        this.numbers = numbers;
        this.currencyForm =currencyForm;
    }

    public Integer getAmount(){
        return this.numbers;
    }

    public String getCurrencyForm(){
        return this.currencyForm;
    }


}
