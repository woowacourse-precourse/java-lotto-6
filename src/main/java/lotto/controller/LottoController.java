package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

    private static int lottoCnt;
    private static List<Lotto> lottos = new ArrayList<>();

    public static void run() {
        setBuyAmount();
        buyLotto();
    }

    private static void setBuyAmount() {
        OutputView.promptForBuyAmount();
        lottoCnt = (InputView.getBuyAmount() / 1000);
    }

    private static void buyLotto() {
        while(lottoCnt-- > 0) {
            lottos.add(new Lotto(setLottoNumbers()));
        }
    }

    private static List<Integer> setLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
