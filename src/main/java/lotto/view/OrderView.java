package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class OrderView {
    public static String askOrderPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printOrderLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
