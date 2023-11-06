package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoResult;
import lotto.views.InputViews;
import lotto.views.OutputViews;
import lotto.domain.Lotto;
import lotto.domain.MakeLottos;

public class LottoController {
    int purchaseAmount;
    int purchaseNum;
    int bonusNumInput;
    int reciveAmount = 0;
    private static List<List<Integer>> allLotto;
    private static Lotto lotto;

    public void run() {
        runReadPurchaseLotto();
        runWritePurchaseLotto();
        runReadWinningNum();
        runReadBonusNum();
        runWriteMatchesNumResult();
    }

    public void runReadPurchaseLotto() {
        while (readPurchaseLotto()) {
        }
        OutputViews.endOfSection();
    }

    public boolean readPurchaseLotto() {
        String purchaseAmountString = InputViews.readPurchaseAmount();
        if (ReadPurchaseLottoModules.isPurchaseAmountInt(purchaseAmountString)) {
            return true;
        }

        purchaseAmount = Integer.parseInt(purchaseAmountString);
        boolean isPositive = ReadPurchaseLottoModules.isPurchaseAmountPositive(purchaseAmount);
        boolean isDivisible1000 = ReadPurchaseLottoModules.isPurchaseAmountDivisible1000(purchaseAmount);
        if (isPositive || isDivisible1000) {
            return true;
        }
        purchaseNum = purchaseAmount / 1000;
        return false;
    }

    public void runWritePurchaseLotto() {
        writePurchaseLotto();
        OutputViews.endOfSection();
    }

    public void writePurchaseLotto() {
        allLotto = MakeLottos.makeLotto(purchaseNum);
        OutputViews.numOfPurchaseLotto(purchaseNum);
        OutputViews.listOfPurchaseLotto(allLotto);
    }

    public void runReadWinningNum() {
        while (readWinningNum()) {
        }
        OutputViews.endOfSection();
    }

    public boolean readWinningNum() {
        List<String> winningNums = ReadWinningNum.splitWinningNums();
        List<Integer> winningNumsInput = new ArrayList<>();
        for (String winningNum : winningNums) {
            if (ReadWinningNum.isWinningNumTypeOfInput(winningNum)) {
                return true;
            }
            winningNumsInput.add(Integer.parseInt(winningNum));
        }
        lotto = ReadWinningNum.makeWinningNumsInput(winningNumsInput);
        if (lotto == null) {
            return true;
        }
        return false;
    }

    public void runReadBonusNum() {
        while (readBonusNum()) {
        }
        OutputViews.endOfSection();
    }

    public boolean readBonusNum() {
        String bonusNum = InputViews.readBonusNum();
        if (ReadWinningNum.isBonusNumInt(bonusNum)) {
            return true;
        }

        bonusNumInput = Integer.parseInt(bonusNum);
        boolean isNumInRange = ReadWinningNum.isBonusNumRange(bonusNumInput);
        boolean isNumInput = lotto.bonusValidateBool(bonusNumInput);
        if (isNumInRange || isNumInput) {
            return true;
        }
        return false;
    }

    public void runWriteMatchesNumResult() {
        writeMatchesNumResult();
        writeReturnPer();
    }

    public void writeMatchesNumResult() {
        lotto.lottoResultSearch(allLotto, bonusNumInput);
        OutputViews.startWriteStat();
        for (LottoResult lottoResultName : LottoResult.values()) {
            String stsMess = lottoResultName.getMatchesMess();
            int matchNum = lottoResultName.getNumOfMatches();
            OutputViews.wrtieResultStatistic(stsMess, matchNum);

            reciveAmount += lottoResultName.getAmount() * matchNum;
        }
    }

    public void writeReturnPer() {
        double per = (double) reciveAmount / purchaseAmount * 100;
        OutputViews.wrtieResultRate(per);
    }
}
