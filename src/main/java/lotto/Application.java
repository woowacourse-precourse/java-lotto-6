package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.BuyLotto;

public class Application {
    static LottoController lottoController = new LottoController();
    public static final int CURRENCY_UNIT = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final long INPUT_PRICE = lottoController.inputBuyLottoPrice();
        final List<Integer> WINNER_NUMBERS = lottoController.inputWinnerNumbers();
        final int BONUS_NUMBER = lottoController.bonusNumbers(WINNER_NUMBERS);
        final List<Lotto> MY_LOTTOS = lottoController.buyLottos(INPUT_PRICE);

        for (int i = 0; i < MY_LOTTOS.size(); i++) {
            Lotto lotto = MY_LOTTOS.get(i);
            System.out.println(lotto.toString());
        }


    }
}
