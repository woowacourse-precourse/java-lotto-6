package lotto;

import java.util.List;
import lotto.controller.LottoController;

public class Application {
    static LottoController lottoController = new LottoController();
    public static final int CURRENCY_UNIT = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final long INPUT_PRICE = lottoController.inputBuyLottoPrice();
        final List<Integer> WINNER_PRICE = lottoController.inputWinnerNumbers();
        final int BONUS_NUMBER = lottoController.BonusNumbers(WINNER_PRICE);
        final int AMOUNT_BUY_LOTTO = (int) (INPUT_PRICE / CURRENCY_UNIT);
        final List<Lotto> MY_LOTTOS;


    }
}
