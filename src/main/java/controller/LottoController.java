package controller;

import model.Lotto;
import model.LottoProfitCalculator;
import model.LottoRepository;
import util.RandomNumberGeneratorUtil;
import view.LottoBonusNumberInputView;
import view.LottoPurchaseInputView;
import view.LottoResultOutputView;
import view.LottoWinningNumberInputView;
import static model.LottoRepository.*;

import java.util.List;
import java.util.Map;

public class LottoController {
    LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();
    RandomNumberGeneratorUtil randomNumberGeneratorUtil = new RandomNumberGeneratorUtil();
    LottoWinningNumberInputView lottoWinningNumberInputView = new LottoWinningNumberInputView();
    LottoBonusNumberInputView lottoBonusNumberInputView = new LottoBonusNumberInputView();
    LottoRepository lottoRepository = new LottoRepository();
    LottoResultOutputView lottoResultOutputView = new LottoResultOutputView();
    LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator();

    public void gameStart() {
        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);

        List<Integer> winningNumbers = lottoWinningNumberInputView.readLottoWinningNumber();

        int bonusNumberValue = lottoBonusNumberInputView.readLottoBonusNumber();

        Map<Rank, Integer> winningDetails = lottoRepository.printLottoResult(winningNumbers, bonusNumberValue);
        lottoResultOutputView.showWinningResult(winningDetails);

        double lottoProfit = lottoProfitCalculator.calculateLottoProfit(winningDetails, lottoPurchase);
        lottoResultOutputView.showLottoProfit(lottoProfit);
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
