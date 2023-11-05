package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public int requestLottoPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String stringPurchaseAmount = Console.readLine();

            try {
                return Integer.parseInt(stringPurchaseAmount);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 구입금액을 입력해 주세요.");
            }
        }
    }

    public void announceLottoPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
