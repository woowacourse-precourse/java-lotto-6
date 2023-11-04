package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Judgement;
import lotto.domain.Numbers;

public class Application {
    static LottoController lottoController = new LottoController();
    public static final int CURRENCY_UNIT = 1000;
    private static long totalReward = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final long INPUT_PRICE = lottoController.inputBuyLottoPrice();
        final List<Lotto> MY_LOTTOS = lottoController.buyLottos(INPUT_PRICE);
        lottoController.outputLottosNumber(MY_LOTTOS);
        final List<Integer> WINNER_NUMBERS = lottoController.inputWinnerNumbers();
        final int BONUS_NUMBER = lottoController.bonusNumbers(WINNER_NUMBERS);

        Numbers numbers = new Numbers();
        Judgement judgement = new Judgement();

        for (Lotto lotto : MY_LOTTOS) {
            int correct = lotto.compareLottoToWinnerNumbers(WINNER_NUMBERS, BONUS_NUMBER);

            if (correct > 2) {
                judgement.setCorrectNumber(correct);
                totalReward += judgement.getReward(correct);
            }
        }

        lottoController.outputTotalResult(judgement);
        System.out.print("총 수익률은 ");
        System.out.print(numbers.rateOfReturn(totalReward, INPUT_PRICE));
        System.out.println("%입니다.");

    }
}
