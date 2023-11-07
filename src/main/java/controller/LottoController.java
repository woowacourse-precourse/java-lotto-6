package controller;

import model.Lotto;
import model.LottoRepository;
import util.RandomNumberGeneratorUtil;
import view.LottoBonusNumberInputView;
import view.LottoPurchaseInputView;
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

    public void gameStart() {
        int lottoPurchase = lottoPurchaseInputView.readLottoPurchaseValidator();
        createLotto(lottoPurchase);
        List<Integer> winningNumbers = lottoWinningNumberInputView.readLottoWinningNumber();
        int bonusNumberValue = lottoBonusNumberInputView.readLottoBonusNumber();
        Map<Integer, Integer> winningDetails = lottoRepository.printLottoResult(winningNumbers, bonusNumberValue);
        showWinningResult(winningDetails);
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

    public void showWinningResult(Map<Integer, Integer> lottoWinningStatistics) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoWinningStatistics.get(RANK_FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningStatistics.get(RANK_FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningStatistics.get(RANK_THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningStatistics.get(RANK_SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningStatistics.get(RANK_FIRST) + "개");
    }
}
