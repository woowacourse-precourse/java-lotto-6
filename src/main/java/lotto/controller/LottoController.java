package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Numbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static ArrayList<Lotto> myLottos = new ArrayList<>();
    public void play() {

    }

    public void start() {
        Money money = new Money();
        buyLottos(money.trial());
    }

    public void buyLottos(int trial) {
        OutputView.printNoticeTrialMessage(trial);
        do {
            List<Integer> numbers = Numbers.makeRandomNumbers();
            myLottos.add(new Lotto(numbers));
        } while (myLottos.size() < trial);
        System.out.println(myLottos);
    }
}
