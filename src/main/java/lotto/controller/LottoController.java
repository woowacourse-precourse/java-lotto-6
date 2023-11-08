package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Numbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static List<Lotto> myLottos = new ArrayList<>();
    private static Lotto winningLotto;
    private static LottoNumber bonusNumber;

    public void play() {
        Money money = new Money();
        buyLottos(money.trial());
        winningLotto = new Lotto(InputView.inputWinningNumbers());
        bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        checkWinning();
    }

    public void buyLottos(int trial) {
        OutputView.printNoticeTrialMessage(trial);
        do {
            List<Integer> numbers = LottoNumber.pickRandomNumbers(6);
            myLottos.add(new Lotto(numbers));
        } while (myLottos.size() < trial);
        OutputView.printBoughtLottos(myLottos);
    }

    public void checkWinning() {
        for (Lotto myLotto : myLottos) {
            int match = calculateWinning(myLotto, winningLotto);
        }
    }

    public int calculateWinning(Lotto lotto1, Lotto lotto2) {
        int count = 0;
        List<Integer> list1 = lotto1.getNumbers();
        List<Integer> list2 = lotto2.getNumbers();
        for (Integer number : list1) {
            if (list2.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
