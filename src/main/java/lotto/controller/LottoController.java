package lotto.controller;

import lotto.domain.draw.DrawingMachine;
import lotto.domain.lotto.Money;
import lotto.dto.input.MoneyDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DrawingMachine drawingMachine;

    public LottoController(InputView inputView, OutputView outputView, DrawingMachine drawingMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.drawingMachine = drawingMachine;
    }

    public void run() {
        Money money = getAmountFromUserInput();
    }

    // imp.
    private Money getAmountFromUserInput() {
        MoneyDto money = inputView.readPurchaseAmount();
        String input = money.value();
        // ref. 서비스에서 dto -> 도메인 객체로 변환
        int amount = Integer.parseInt(input);
        return Money.fromInitialMoney(amount);
    }
}
