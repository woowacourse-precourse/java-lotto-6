package lotto.domain;

import lotto.util.InputUtil;
import lotto.util.LottoGameUtil;
import lotto.util.OutputUtil;

import java.util.List;
import java.util.stream.Collectors;

public interface LottoGame {

    static void play() {
        String purchaseAmount = getPurchaseAmount();
        OutputUtil.println(LottoGameUtil.convertPurchaseAmount(purchaseAmount) + LottoGameMessage.PURCHASE_COMPLETED_MESSAGE);
        List<Lotto> lottoNumbers = createLottoNumbers(LottoGameUtil.convertPurchaseAmount(purchaseAmount));
        Lotto winningNumber = inputLottoNumber();
        OutputUtil.println(LottoGameMessage.REQUEST_BONUS_NUMBERS);
        int bonusNumber = inputBonusNumber();
        viewWinningStatistics(lottoNumbers, winningNumber, bonusNumber, InputUtil.convert(purchaseAmount));
    }

    static void viewWinningStatistics(List<Lotto> lottoNumbers, Lotto winningNumber, int bonusNumber, int purchaseAmount) {
        OutputUtil.println(LottoGameMessage.WINNING_STATISTICS);
        OutputUtil.println(LottoGameMessage.CONTOUR);
        List<LottoScore> winningStatistics = getWinningStatistics(lottoNumbers, winningNumber, bonusNumber);
        LottoGameUtil.getWinningStatistics(winningStatistics).view(purchaseAmount);
    }

    static List<LottoScore> getWinningStatistics(List<Lotto> lottoNumbers, Lotto winningNumber, int bonusNumber) {
        return lottoNumbers.stream()
                .map(lotto -> lotto.compare(winningNumber, bonusNumber))
                .collect(Collectors.toList());
    }

    static int inputBonusNumber() {
        String bonusNumber = InputUtil.EMPTY;
        try {
            bonusNumber = InputUtil.readLineByNumber();
        } catch (IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            inputBonusNumber();
        }
        return InputUtil.convert(bonusNumber);
    }

    static Lotto inputLottoNumber() {
        OutputUtil.println(LottoGameMessage.REQUEST_WINNING_NUMBERS);
        String winningNumber = InputUtil.EMPTY;
        try {
            winningNumber = InputUtil.readLine();
            LottoGameUtil.validNumbersContainsSeparator(winningNumber);
        } catch (IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            inputLottoNumber();
        }
        return new Lotto(LottoGameUtil.convertLottoNumber(winningNumber));
    }

    static List<Lotto> createLottoNumbers(int purchaseAmount) {
        List<Lotto> lottoNumbers = LottoGameUtil.generateLottoNumbers(purchaseAmount);
        lottoNumbers.forEach(lotto -> lotto.viewNumberStatus());
        return lottoNumbers;
    }

    static String getPurchaseAmount() {
        OutputUtil.println(LottoGameMessage.REQUEST_PURCHASE_AMOUNT);
        String amount = InputUtil.EMPTY;
        try {
            amount = InputUtil.readLineByNumber();
            LottoGameUtil.validPurchaseAmountFormat(amount);
        } catch (IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            getPurchaseAmount();
        }
        return amount;
    }
}
