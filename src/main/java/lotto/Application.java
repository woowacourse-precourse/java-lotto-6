package lotto;

import java.util.List;
import lotto.controller.LottoController;

public class Application {
    static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final long INPUT_PRICE = lottoController.inputBuyLottoPrice();
        final List<Integer> WINNER_PRICE = lottoController.inputWinnerNumbers();


    }
}
