package lotto.View;

public class OutputUI {
    public static void printRequestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printSuccessfullyPurchased(int price) {
        System.out.printf("%d개를 구매했습니다.%n", price);
    }
}
