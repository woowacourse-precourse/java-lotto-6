package controller;

import model.Lotto;
import model.LottoRepository;
import util.RandomNumberGeneratorUtil;
import view.LottoBonusNumberInputView;
import view.LottoPurchaseInputView;
import view.LottoWinningNumberInputView;

public class LottoController {
    LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();
    RandomNumberGeneratorUtil randomNumberGeneratorUtil = new RandomNumberGeneratorUtil();
    LottoWinningNumberInputView lottoWinningNumberInputView = new LottoWinningNumberInputView();
    LottoBonusNumberInputView lottoBonusNumberInputView = new LottoBonusNumberInputView();
    LottoRepository lottoRepository = new LottoRepository();

    public void gameStart() {
        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);
        lottoWinningNumberInputView.readLottoWinningNumber();
        lottoBonusNumberInputView.readLottoBonusNumber();
    }

    public void createLotto(int price) {
        int totalLottoCount = countTotalLotto(price);
        displayPurchaseQuantity(totalLottoCount);
        for (int count = 0; count < totalLottoCount; count++) {
            Lotto lotto = new Lotto(randomNumberGeneratorUtil.randomNumbersGenerate());
            lottoRepository.addLotto(lotto);
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
