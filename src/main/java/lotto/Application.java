package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        int howMuchPurchase = Integer.parseInt(Console.readLine());
        int howManyLotto = howMuchPurchase / 1000;

        List<Lotto> lottoPapers = generateLottoPaper(howManyLotto);

        for (Lotto lotto : lottoPapers) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Lotto> generateLottoPaper(int howManyLotto) {
        List<Lotto> lottoPapers = new ArrayList<>();
        for (int i = 0; i < howManyLotto; i++) {
            lottoPapers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoPapers;
    }
}
