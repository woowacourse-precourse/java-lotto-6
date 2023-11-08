package lotto;

import lotto.controller.LottoController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.play();
    }
}

