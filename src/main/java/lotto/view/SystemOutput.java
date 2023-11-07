package lotto.view;

public class SystemOutput {
    // 게임 개수를 출력한다
    // 발행된 로또들을 출력한다
    // rank에 계산된 값을 출력한다
    // rate 값을 출력한다

    public static void printPurchaseAmount(int purchaseAmount) {
        String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

        System.out.printf((OUTPUT_MESSAGE) + "%n",(purchaseAmount/1000));
    }
}
