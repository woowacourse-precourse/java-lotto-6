package lotto.controller;

import lotto.model.Money;
import lotto.util.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        requestMoney();
        /*
        구입금액_입력받기(); --> inputView에서 받고, dto로 전달
        로또번호추출();
        당첨번호_입력받기();
        보너스번호_입력받기();
        결과계산하기(); --> 서비스 계층
        출력하기(outputView);
         */
    }

    Money requestMoney() {
        outputView.printMessage(Message.REQUEST_MONEY);
        while (true) {
            try {
                return new Money(inputView.requestInteger());
            } catch (IllegalArgumentException e) {
                // outputView 호출
                outputView.printError(e.getMessage());
            }
        }
    }

}
