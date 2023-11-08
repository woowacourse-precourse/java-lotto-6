package lotto;

import java.util.List;
import lotto.domain.Display;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Operator;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        Display display = new Display();
        Operator operator = new Operator();

        String purchaseAmountText = lottoMachine.readAmount();
        int purchaseAmount = lottoMachine.purchaseAmountTextToInt(purchaseAmountText);
        int issueCount = lottoMachine.amountToIssueCount(purchaseAmount);

        List<Lotto> lottos = lottoMachine.generate(issueCount);
        display.lottos(lottos);

        String winningNumberText = lottoMachine.readWinningNumber();
        Lotto winningLotto = lottoMachine.textToLotto(winningNumberText);

        String bonusNumberText = lottoMachine.readBonusNumberText();
        int bonusNumber = lottoMachine.bonusNumberTextToInt(bonusNumberText);

        List<Integer> corrects = operator.matchNumbers(lottos, winningLotto);
        List<Integer> bonusCorrects = operator.matchBonusNumber(lottos, bonusNumber);

        display.winningRecords(corrects, bonusCorrects);
        display.profitRate(purchaseAmount);
    }
}
