package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    // 로또 구입 금액 입력 받기
    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    // 로또 당첨 번호 입력 받기
    public static Integer inputWinningNumber() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }


}
