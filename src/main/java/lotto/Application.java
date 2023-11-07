package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.WinningLotto.convertToIntegerList;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}

