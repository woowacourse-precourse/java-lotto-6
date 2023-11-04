package lotto.output;

public class PrintService {

    public static void requestInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestInputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void informPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
