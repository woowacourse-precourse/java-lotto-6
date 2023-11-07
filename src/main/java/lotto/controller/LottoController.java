package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.LottoModel;
import lotto.model.LottoPrize;
import lotto.view.LottoBonusInputView;
import lotto.view.LottoBuyView;
import lotto.view.LottoInputView;
import lotto.view.LottoWinInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoPrize.getPrizeRankByMatch;

public class LottoController {
    LottoModel lottoModel = new LottoModel();
    LottoInputView lottoInputView = new LottoInputView();
    LottoWinInputView lottoWinInputView = new LottoWinInputView();
    LottoBuyView lottoBuyView = new LottoBuyView();
    LottoBonusInputView lottoBonusInputView = new LottoBonusInputView();

    public void runLotto() {
        // 1. 구입 금액 입력
        int price = lottoInputView.purchasePriceInput();
        lottoModel.setInputPrice(price);
        lottoModel.calcPurchasedCount();

        // 2. 로또 구매
        int count = lottoModel.getPurchasedCount();
        List<Lotto> purchasedLotto = lottoModel.getPurchasedLotto(count);
        lottoBuyView.printPurchaseLog(purchasedLotto, count);

        // 3. 당첨 번호 입력
        List<Integer> winNumbers = lottoWinInputView.winNumberInput();

        // 4. 보너스 번호 입력
        int bonus = lottoBonusInputView.getBonusInput(winNumbers);

        // 5. 당첨 통계
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        int[] prizeLog = new int[6];
        Arrays.fill(prizeLog, 0);
        for (Lotto lotto : purchasedLotto) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int lottoNum : lotto.getLotto()) {
                if (winNumbers.contains(lottoNum)) {
                    matchCount += 1;
                }
                if (lottoNum == bonus) {
                    bonusMatch = true;
                }
            }
            // 등수 판별
            LottoPrize info = getPrizeRankByMatch(matchCount, bonusMatch);
            lottoPrizes.add(info);
            prizeLog[info.getRank()] += 1;
        }
//        System.out.println(Arrays.toString(prizeLog));

        // 5-2. 당첨 통계 출력
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeLog[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeLog[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeLog[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeLog[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeLog[1]);

        // 6.총 수익률 출력
        long totalPrize = 0;
        for (LottoPrize info : lottoPrizes) {
            totalPrize += info.getPrize();
        }
        double rateOfReturn = (double) totalPrize / price * 100;
//        rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}