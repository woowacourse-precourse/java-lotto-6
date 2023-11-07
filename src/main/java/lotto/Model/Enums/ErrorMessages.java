package lotto.Model.Enums;

public enum ErrorMessages {
    PURCHASE_PRICE_FORM(String.format("[ERROR] %d원 단위의 정수로 입력해 주세요.", Prices.ONE_LOTTO.intValue())),
    PURCHASE_PRICE_MINIMUM("[ERROR] 최소 1개를 살 수 있는 금액을 입력해 주세요."),
    WINNING_NUMBER_FORM(String.format("[ERROR] %d개의 숫자를 쉼표를 기준으로 구분해 입력해 주세요.",
            MeaningfulNumbers.LOTTO_NUMBER_WITHOUT_BONUS.intValue()));

    final private String string;
    ErrorMessages(String string){this.string = string;}
    public String getString(){return string;}
}
