package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoBoard;

public class InputController {
    private LottoBoard lottoBoard;

    public void startGame() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer money = Integer.parseInt(Console.readLine());
        System.out.println();

        lottoBoard = new LottoBoard(money);
    }
}
