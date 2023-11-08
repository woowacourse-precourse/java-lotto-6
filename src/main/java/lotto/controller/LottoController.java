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
    private static List<Integer> answerlottoNumbers;

    public static void run() {
        setBuyAmount();
        buyLotto();
        setAnswerLottoNumbers();
    }

    private static void setBuyAmount() {
        OutputView.promptForBuyAmount();
        lottoCnt = (InputView.getBuyAmount() / 1000);
    }

    private static void buyLotto() {
        OutputView.printLottoCnt(lottoCnt);
        while (lottoCnt-- > 0) {
            Lotto lotto = new Lotto(setLottoNumbers());
            lottos.add(lotto);
            OutputView.printLottoList(lotto.getNumbers());
        }

    }

    private static List<Integer> setLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private static void setAnswerLottoNumbers() {
        OutputView.promptForAnswerLottoNumbers();
        answerlottoNumbers = InputView.getAnswerLottoNumbers();

    }
}
