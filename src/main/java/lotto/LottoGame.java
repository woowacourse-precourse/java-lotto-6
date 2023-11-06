package lotto;

import lotto.console.InputConsole;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    void run() {
        Money money = InputConsole.getPurchaseAmount();

        System.out.println(money.getNumberOfPurchasedLotto() + "개를 구매했습니다.");

        List<Lotto> lottos = getLottery(money.getNumberOfPurchasedLotto());

        lottos.forEach(System.out::println);

        Lotto winningNumbers = InputConsole.getWinningNumbers();

        int bonusNumber = InputConsole.getBonusNumber();

        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("winning numbers: " + winningNumbers);
    }

    private List<Lotto> getLottery(int lottoCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(new Lotto());
        }
        return result;
    }

}
