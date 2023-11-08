package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> answerlottoNumbers;
    private static List<Result> results;

    private static final int LOTTO_PRICE = 1000;
    private static final double PERCENTAGE = 100.0;
    private static final int MIN_CORRECT_CNT = 3;
    private static final int SECOND_CORRECT_CNT = -5;

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
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = new Lotto(setLottoNumbers());
            lottos.add(lotto);
            OutputView.printLottoList(lotto.getNumbers());
        }

    }

    private static List<Integer> setLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
            if (correctCnt >= MIN_CORRECT_CNT || correctCnt == SECOND_CORRECT_CNT) {
                price += getPrice(correctCnt);
            }
        }

        OutputView.printResults(results);
        OutputView.printBenefits(getBenefits(price, lottoCnt));
    }

    private static double getBenefits(int price, int lottoCnt) {
        return (price / (double) (lottoCnt * LOTTO_PRICE)) * PERCENTAGE;
    }

    public static int getPrice(int correctCnt) {
        for (Result result : results) {
            if (result.correctCnt() == correctCnt) {
                result.addCnt();
                return result.price();
            }
        }

        return 0;
    }
}
