package controller;

import util.RandomNumberGeneratorUtil;
import view.LottoPurchaseInputView;
import view.LottoWinningNumberInputView;

public class LottoController {
    LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();
    RandomNumberGeneratorUtil randomNumberGeneratorUtil = new RandomNumberGeneratorUtil();
    LottoWinningNumberInputView lottoWinningNumberInputView = new LottoWinningNumberInputView();

    public void gameStart() {
        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);
        lottoWinningNumberInputView.readLottoWinningNumber();
    }

    public void createLotto(int price) {
        int totalLottoCount = countTotalLotto(price);
        displayPurchaseQuantity(totalLottoCount);
        for (int count = 0; count < totalLottoCount; count++) {
            randomNumberGeneratorUtil.randomNumbersGenerate();
        }
        System.out.println();
    }

    private int countTotalLotto(int price) {
        int totalCount = price / 1000;
        return totalCount;
    }

    private void displayPurchaseQuantity(int totalLottoCount) {
        System.out.println();
        System.out.println(totalLottoCount + "개를 구매했습니다.");
    }
}
