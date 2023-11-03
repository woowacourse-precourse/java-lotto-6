package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    public static void printRequestBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }


    public static void printCreatedLottos(Lottos lottos) {
        List<List<Integer>> numbers = lottos.getLottos().stream().map(Lotto::getNumbers).toList();
        numbers.forEach(number -> System.out.println(number));
    }

    public static void printRequestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
