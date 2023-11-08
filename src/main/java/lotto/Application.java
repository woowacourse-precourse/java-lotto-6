package lotto;

import lotto.common.ExceptionMessage;
import lotto.controller.LottoController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.play();
    }
}

