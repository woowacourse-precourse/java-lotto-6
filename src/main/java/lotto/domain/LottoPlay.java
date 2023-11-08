package lotto.domain;

import lotto.util.MessageUtil;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    public void play() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                LottoPurchase purchaseInfo = lottoPurchase.getPurchaseInfo();
                LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();
                LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);
                lottoPrize.getLottoStats(purchaseInfo.getUserLottos(), purchaseInfo.getPurchaseAmount());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}