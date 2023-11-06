package lotto.controller;

public class UserInputMessage {
    public static final String REQUEST_LOTTO_PURCHASE_AMOUNT = "로또를 구입할 금액을 %s원 단위로 입력하세요.";
    public static final String REQUEST_WINNING_NUMBERS = "로또 당첨 번호를 입력하세요. 번호는 쉼표(,)를 기준으로 구분합니다.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력하세요.";
    public static final String LOTTO_TICKETS_PURCHASED_MESSAGE = "%d개를 구매했습니다.";

    private UserInputMessage() {
    }
}
