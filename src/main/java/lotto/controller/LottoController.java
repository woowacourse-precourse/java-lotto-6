package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    
    private final InputView inputView;
    private final OutputView outputView;
    
    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    
    public void start() {
        LottoPurchase lottoPurchase = inputAmount();
        outputView.printNewLine();
        
        int ticketCount = lottoPurchase.calculateTicketCount();
        outputView.printTicketCount(ticketCount);
    }
    
    private LottoPurchase inputAmount() {
        try {
            return new LottoPurchase(inputView.inputAmount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputAmount();
        }
    }
}
