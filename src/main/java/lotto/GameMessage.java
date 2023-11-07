package lotto;

public class GameMessage {
    public static void priceInputRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoCountMessage(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }
}
