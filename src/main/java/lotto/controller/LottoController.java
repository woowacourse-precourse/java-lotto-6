package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> answerlottoNumbers;
    private static List<Result> results;


    private static int lottoCnt;
    private static int bonusNumber;
    private static int price = 0;

    public static void run() {
        setBuyAmount();
        buyLotto();
        setAnswerLottoNumbers();
        setBonusNumber();
        setResult();
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

    private static void setBonusNumber() {
        OutputView.promptForBonusNumber();
        bonusNumber = InputView.getBonusNumber();
    }

    public static List<Integer> getAnswerlottoNumbers() {
        return answerlottoNumbers;
    }

    public static void setResult() {
        results = List.of(Result.FIFTH, Result.FOURTH, Result.THIRD, Result.SECOND, Result.FIRST);

        for (Lotto lotto : lottos) {
            int correctCnt = lotto.getCorrectCount(answerlottoNumbers, bonusNumber);
            for (Result result : results) {
                if (result.CorrectCnt() == correctCnt) {
                    result.plusCnt();
                    price += result.Price();
                    break;
                }
            }
        }
    }
}
