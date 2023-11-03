package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRequestPurchaseAmountMessage();
        int purchasePrice = getPurchasePrice();

        LottoTicket lottoTicket = getLottoTicket(purchasePrice);
        printLottoNumbers(lottoTicket);

        outputView.printRequestWinningNumberMessage();
        Lotto winningLotto = getWinningLotto();
    }

    public int getPurchasePrice() {
        while (true) {
            try {
                return inputView.getDivisibleNumberInRange(LottoTicketMachine.LOTTO_PRICE, LottoTicketMachine.MAX_PURCHASE_AMOUNT, LottoTicketMachine.LOTTO_PRICE);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public LottoTicket getLottoTicket(int purchasePrice) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        return lottoTicketMachine.getLottoTicket(purchasePrice);
    }

    public void printLottoNumbers(LottoTicket lottoTicket) {
        outputView.printLottoCount(lottoTicket.getLottoCount());
        outputView.printLottoTicketNumbers(lottoTicket.getLottoNumbers());
    }

    public Lotto getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.getNumbersSplitByComma(Lotto.LOTTO_NUMBER_MIN,
                        Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_NUMBERS_SIZE);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
