package lotto.controller;

import lotto.model.*;
import lotto.util.LottoNumberGenerator;
import lotto.util.NumberGenrator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.constant.OutputMessageConstants;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.constant.PrizeConstants.*;

public class LottoController {
    private static final NumberGenrator lottoNumberGenerator = new LottoNumberGenerator();

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        Lottos lottos = new Lottos(createLotto(purchaseAmount.getLottoCount()));
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);

        LottoResult lottoResult = createLottoResult(winningNumber, lottos, bonusNumber);
        printWinningResult(lottoResult);
        printRateOfReturn(lottoResult.caclurateReturnOfRate(purchaseAmount.getAmount()));
    }

    private void printRateOfReturn(double returnOfRate) {
        OutputView.printRateOfReturnMessage(returnOfRate);
    }

    private void printWinningResult(LottoResult lottoResult) {
        OutputView.printNewLine();
        OutputView.printOutputMessage(OutputMessageConstants.WINNING_RESULT_OUTPUT_MESSAGE.getMessage());
        OutputView.printOutputMessage(OutputMessageConstants.DIVIDER_OUTPUT_MESSAGE.getMessage());
        OutputView.printWinningResult(FIFTH_PRIZE.getCount(), FIFTH_PRIZE.getPrice(), lottoResult.getRank().getFifthPlace());
        OutputView.printWinningResult(FOURTH_PRIZE.getCount(), FOURTH_PRIZE.getPrice(), lottoResult.getRank().getFourthPlace());
        OutputView.printWinningResult(THIRD_PRIZE.getCount(), THIRD_PRIZE.getPrice(), lottoResult.getRank().getThirdPlace());
        OutputView.printSecondPlace(SECOND_PRIZE.getCount(), SECOND_PRIZE.getPrice(), lottoResult.getRank().getSecondPlace());
        OutputView.printWinningResult(FIRST_PRIZE.getCount(), FIRST_PRIZE.getPrice(), lottoResult.getRank().getFirstPlace());
    }

    private LottoResult createLottoResult(WinningNumber winningNumber, Lottos lottos, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);
        lottoResult.calcurateLottoRank();
        return lottoResult;
    }

    private List<Lotto> createLotto(int lottoCount) {
        OutputView.printLottoCount(lottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            OutputView.printLottoNumber(lotto.getNumbers());
            lottos.add(lotto);
        }
        OutputView.printNewLine();
        return lottos;
    }

    private PurchaseAmount getPurchaseAmount() {
        while(true) {
            try {
                OutputView.printOutputMessage(OutputMessageConstants.PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
                return new PurchaseAmount(InputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                OutputView.printOutputMessage(e.getMessage());
            }
        }
    }

    private WinningNumber getWinningNumber() {
        while(true) {
            try {
                OutputView.printOutputMessage(OutputMessageConstants.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
                return new WinningNumber(InputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printOutputMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        OutputView.printNewLine();
        while (true) {
            try {
                OutputView.printOutputMessage(OutputMessageConstants.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
                return new BonusNumber(InputView.readBonusNumber(), winningNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printOutputMessage(e.getMessage());
            }
        }
    }
}
