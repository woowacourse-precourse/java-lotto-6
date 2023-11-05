package lotto;

import domain.*;
import util.MessageUtil;

public class LottoRun {
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final LottoBonusNumber lottoBonusNumber = new LottoBonusNumber();
    public void run() {
        messageUtil.printPurchaseAmount();

        LottoPurchase purchaseInfo = null;
        LottoWinningNumber winningNumInfo = null;
        LottoBonusNumber bonusNumInfo = null;
        LottoResultCompute resultCompute;

        purchaseInfo = getValidLottoPurchaseInfo(purchaseInfo);
        winningNumInfo = getValidWinningNumInfo(winningNumInfo);
        bonusNumInfo = getValidBonusNumInfo(bonusNumInfo);
        resultCompute = new LottoResultCompute(winningNumInfo, bonusNumInfo);
        resultCompute.getLottoResultComputeInfo(purchaseInfo.getUserLottos(), purchaseInfo.getUserLottoAmount());
    }

    private LottoPurchase getValidLottoPurchaseInfo(LottoPurchase purchaseInfo){
        purchaseInfo = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                purchaseInfo = lottoPurchase.getLottoPurchaseInfo();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseInfo;
    }
    private LottoWinningNumber getValidWinningNumInfo(LottoWinningNumber winningNumInfo) {
        winningNumInfo = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                winningNumInfo = lottoWinningNumber.getLottoWinningNumInfo();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumInfo;
    }
    private LottoBonusNumber getValidBonusNumInfo(LottoBonusNumber bonusNumInfo) {
        bonusNumInfo = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                bonusNumInfo = lottoBonusNumber.getLottoBonusNumInfo();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumInfo;
    }
}
