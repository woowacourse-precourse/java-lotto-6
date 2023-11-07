package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BuyAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private  final InputView inputView;
    private  final OutputView outputView;
    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        initUserInput();
        // TODO 1.당첨 번호 및 보너스 입력 처리
        // TODO 2.로또 발행 및 출력
    }

    private void initUserInput() {
        int buyAmount = initBuyAmount().getBuyAmount();
        // TODO 1.당첨 번호 및 보너스 입력 처리
    }

    private BuyAmountValidator initBuyAmount() {
        try {
            return inputView.readBuyAmount();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return initBuyAmount();
        }
    }

    // TODO 예외 발생 시, 재입력을 위한 콘솔 반환
    public void close() {
        Console.close();
    }
}
