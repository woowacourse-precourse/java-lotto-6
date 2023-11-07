package controller;

import view.LottoPurchaseInputView;

public class LottoController {
    public void gameStart() {
        LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();

        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);
    }

    public void createLotto(int price) {
        int totalLottoCount = countTotalLotto(price);
        displayPurchaseQuantity(totalLottoCount);
    }

    private int countTotalLotto(int price) {
        int totalCount = price / 1000;
        return totalCount;
    }

    private void displayPurchaseQuantity(int totalLottoCount) {
        System.out.println(totalLottoCount + "개를 구매했습니다.");
    }
}
