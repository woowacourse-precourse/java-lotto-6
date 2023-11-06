package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoGame;
import lotto.view.Viewer;

public class InputController {
    private LottoGame LottoGame;
    private Viewer viewer = new Viewer();
    private Integer money;

    public void startGame() {
        viewer.printArgs("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        System.out.println();
    }

    public Integer getMoney() {
        return money;
    }

}
