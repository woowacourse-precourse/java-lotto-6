package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.controller.GameController;

import lotto.domain.lotto.LottoPaper;
import lotto.domain.prize.Prize;
import lotto.domain.result.LottoResult;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        LottoPaper lottoPaper = gameController.purchaseLotto();

        LottoResult lottoResult = gameController.confirmResult(lottoPaper);

        Prize prize = gameController.receivePrize(lottoResult);

        gameController.checkYield(lottoPaper, prize);

        Console.close();
    }
}

