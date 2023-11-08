package lotto;

import lotto.domain.Lotto;
import lotto.util.LottoGenerator;
import lotto.util.Referee;
import lotto.view.InputLotto;
import lotto.view.OutputLotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseCount = InputLotto.purchaseMoney();

        List<Lotto> lottos = LottoGenerator.createLottos(purchaseCount);
        OutputLotto.counts(purchaseCount);
        OutputLotto.numbers(lottos);

        Lotto answer = new Lotto(InputLotto.answerNumber());
        int bonus = InputLotto.bonusNumber();

        int[] winning = Referee.compareToLottos(lottos, answer, bonus);
        double income = Referee.calculateIncome(winning, purchaseCount);
        OutputLotto.winningHistory(winning);
        OutputLotto.incomeRate(income);
    }
}
