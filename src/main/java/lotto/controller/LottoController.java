package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningNumber;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;

public class LottoController {

    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final WinningNumber winningNumber = new WinningNumber();


    public void play() {
        messageUtil.printPurchaseInput();
        try {
            LottoPurchase purchaseInfo = lottoPurchase.getPurchaseInfo();
            WinningNumber winningNumbersInfo = winningNumber.getWinningNumberInfo();
            LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);
            lottoPrize.getLottoStatistics(purchaseInfo.getUserLottos(), purchaseInfo.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
