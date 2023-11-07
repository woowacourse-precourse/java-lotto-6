package lotto.Model.Enums;

public enum ErrorMessages {
    PURCHASE_PRICE_FORM(String.format("[ERROR] %d원 단위의 정수로 입력해 주세요.", Prices.ONE_LOTTO.ordinal())),
    PURCHASE_PRICE_MINIMUM("[ERROR] 최소 1개를 살 수 있는 금액을 입력해 주세요.");

    final private String string;
    ErrorMessages(String string){this.string = string;}
    public String getString(){return string;}
}
