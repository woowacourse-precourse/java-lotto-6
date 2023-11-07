package lotto.view;

public final class inputMessage {
    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRIZE_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String BONUS_MESSAGE = "보너스 번호를 입력해주세요.";

    public static void priceMessage() {
        System.out.println(PRICE_MESSAGE);
    }

    public static void prizeMessage() {
        System.out.println(PRIZE_MESSAGE);
    }

    public static void bonusMessage() {
        System.out.println(BONUS_MESSAGE);
    }
}
