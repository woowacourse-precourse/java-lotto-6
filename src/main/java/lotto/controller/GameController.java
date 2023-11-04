package lotto.controller;

import lotto.domain.Cash;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cash cash;
    private Lottos lottos;
    private Prizes prizes;

    public GameController(
            InputView inputView,
            OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        createCash();
        // 발행 로또 내역 출력
        // 당첨 번호 입력
        // 보너스 번호 입력
        // 당첨 통계 출력
    }

    private void createCash() {
        cash = inputView.InputCash();
        System.out.println();
    }




}
