package lotto.controller;

import lotto.model.*;
import lotto.model.constant.PrizeConstants;
import lotto.util.ConvertUtil;
import lotto.util.LottoNumberGenerator;
import lotto.util.NumberGenrator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.constant.PrizeConstants.*;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
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
        outputView.printRateOfReturnMessage(returnOfRate);
    }

    private void printWinningResult(LottoResult lottoResult) {
        outputView.printNewLine();
        outputView.printResultMessage();
        outputView.printWinningResult(FIFTH_PRIZE.getCount(), FIFTH_PRIZE.getPrice(), lottoResult.getRank().getFifthPlace());
        outputView.printWinningResult(FOURTH_PRIZE.getCount(), FOURTH_PRIZE.getPrice(), lottoResult.getRank().getFourthPlace());
        outputView.printWinningResult(THIRD_PRIZE.getCount(), THIRD_PRIZE.getPrice(), lottoResult.getRank().getThirdPlace());
        outputView.printSecondPlace(SECOND_PRIZE.getCount(), SECOND_PRIZE.getPrice(), lottoResult.getRank().getSecondPlace());
        outputView.printWinningResult(FIRST_PRIZE.getCount(), FIRST_PRIZE.getPrice(), lottoResult.getRank().getFirstPlace());
    }
    private LottoResult createLottoResult(WinningNumber winningNumber, Lottos lottos, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);
        lottoResult.calcurateLottoRank();
        return lottoResult;
    }

    private List<Lotto> createLotto(int lottoCount) {
        outputView.printLottoCount(lottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            outputView.printLottoNumber(lotto.getNumbers());
            lottos.add(lotto);
        }
        outputView.printNewLine();
        return lottos;
    }

    private PurchaseAmount getPurchaseAmount() {
        while(true) {
            try {
                outputView.printPurchaseAmountInputMessage();
                return new PurchaseAmount(inputView.readPurchaseAmount());
            }catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber getWinningNumber() {
        while(true) {
            try {
                outputView.printWinningNumbersInputMessage();
                return new WinningNumber(inputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        outputView.printNewLine();
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                return new BonusNumber(inputView.readBonusNumber(), winningNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
