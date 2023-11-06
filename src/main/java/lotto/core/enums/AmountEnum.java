package lotto.core.enums;

public enum AmountEnum {

    MIN_VALUE(1000,"1,000"),
    MAX_VALUE(2147483000,"2,147,483,000"),
    ZERO_VALUE(0, "2,147,483,000");
    private final Integer value;
    private final String currencyForm;

    AmountEnum(Integer value, String currencyForm) {
        this.value = value;
        this.currencyForm =currencyForm;
    }

    public Integer getAmount(){
        return this.value;
    }

    public String getCurrencyForm(){
        return this.currencyForm;
    }


}
