package view;

import dto.LottoTickets;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int requirePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.enterPurchaseAmount();
    }

    public void showLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTickets(lottoTickets);
    }
}
