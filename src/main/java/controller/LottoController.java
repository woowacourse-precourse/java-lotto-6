package controller;

import util.RandomNumberGeneratorUtil;
import view.LottoPurchaseInputView;

public class LottoController {
    LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();
    RandomNumberGeneratorUtil randomNumberGeneratorUtil = new RandomNumberGeneratorUtil();

    public void gameStart() {
        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);
    }

    public void createLotto(int price) {
        int totalLottoCount = countTotalLotto(price);
        displayPurchaseQuantity(totalLottoCount);

        for (int count = 0; count < totalLottoCount; count++) {
            randomNumberGeneratorUtil.randomNumbersGenerate();
        }
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
