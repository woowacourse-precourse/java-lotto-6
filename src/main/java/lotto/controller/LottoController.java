package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoWinCategory;
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
        LottoPurchase lottoPurchase = getLottoPurchase();
        LottoTicket lottoTicket = getLottoTicket(lottoPurchase);
        printLottoNumbers(lottoTicket);

        Lotto winningLotto = getWinningLottoNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);

        Map<LottoWinCategory, Integer> winningStatistics = getWinningStatistics(lottoDraw, lottoTicket);

        getWinningRate(winningStatistics, lottoPurchase, lottoDraw);
    }

    public LottoPurchase getLottoPurchase() {
        outputView.printRequestPurchaseAmountMessage();
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
        outputView.printRequestWinningNumberMessage();
        while (true) {
            try {
                return inputView.getWinningLottoNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(Lotto winningLotto) {
        outputView.printRequestBonusNumberMessage();
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

    public Map<LottoWinCategory, Integer> getWinningStatistics(LottoDraw lottoDraw, LottoTicket lottoTicket) {
        Map<LottoWinCategory, Integer> winningResult = lottoDraw.getWinnings(lottoTicket);
        outputView.printWinningStatistics(winningResult);
        return winningResult;
    }

    public void getWinningRate(Map<LottoWinCategory, Integer> winningStatistics, LottoPurchase lottoPurchase, LottoDraw lottoDraw) {
        double winningRate = lottoDraw.getWinningRate(winningStatistics, lottoPurchase.getMoney());
        outputView.printWinningRate(winningRate);
    }

    private void checkBonusNumberDuplicatedWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

}
