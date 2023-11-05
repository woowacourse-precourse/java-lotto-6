package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.dto.LottoPurchase;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoDraw;
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
        LottoPurchase lottoPurchase = getLottoPurchase();

        LottoTicket lottoTicket = getLottoTicket(lottoPurchase);
        printLottoNumbers(lottoTicket);

        outputView.printRequestWinningNumberMessage();
        Lotto winningLotto = getWinningLottoNumbers();

        outputView.printRequestBonusNumberMessage();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);
    }

    public LottoPurchase getLottoPurchase() {
        while (true) {
            try {
                return inputView.getLottoPurchaseMoney();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public LottoTicket getLottoTicket(LottoPurchase purchasePrice) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        return lottoTicketMachine.getLottoTicket(purchasePrice);
    }

    public void printLottoNumbers(LottoTicket lottoTicket) {
        outputView.printLottoCount(lottoTicket.getLottoCount());
        outputView.printLottoTicketNumbers(lottoTicket.getLottoNumbers());
    }

    public Lotto getWinningLottoNumbers() {
        while (true) {
            try {
                return inputView.getWinningLottoNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                BonusNumber bonusNumber = inputView.getBonusNumber();
                checkBonusNumberDuplicatedWithWinningNumbers(winningLotto.getNumbers(), bonusNumber.getNumber());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void checkBonusNumberDuplicatedWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
