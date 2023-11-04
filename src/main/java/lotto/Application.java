package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");
        int count = purchase();
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = createLottos(count);
    }

    private static int purchase() {
        try {
            return Lotto.purchaseCount(Integer.parseInt(readLine()));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력된 값이 숫자가 아닙니다.");
            return purchase();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 지불한 금액이 나누어 떨어지지 않습니다.");
            return purchase();
        }
    }

    private static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            System.out.println(lotto.numberDescription());
        }

        return lottos;
    }
}
