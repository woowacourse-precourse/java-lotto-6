package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.LottoWinStatusView;

public class LottoResultChecker {
    /* lottoResult는 당첨 등수 - 1를 의미.
    *  lottoResult[0]는 번호 6개 일치, 즉 1등 당첨 로또를 의미함
    * */
    private final List<Long> WINNING_PRIZES =
            new ArrayList<>(List.of(2000000000L, 30000000L, 1500000L, 50000L, 5000L));
    private List<Integer> lottoResult;
    private long totalProfit;

    public LottoResultChecker(User user, List<Integer> winNumbers, int bonusNumber) {
        String test;
        initLottoResult();
        setLottoResult(user.getUserLottos(), winNumbers, bonusNumber);
        LottoWinStatusView.displayLottoPrize(lottoResult);
        calculateProfit();
        LottoWinStatusView.displayTotalProfit(totalProfit, user.getBuyingPrice());
    }
    private void calculateProfit() {
        this.totalProfit = 0;

        for (int i = 0; i < 5; ++i) {
            this.totalProfit += (long) this.lottoResult.get(i) * this.WINNING_PRIZES.get(i);
        }
    }
    private void setLottoResult(List<Lotto> userLotto, List<Integer> winNumbers, int bonusNumber) {
        for (Lotto lotto : userLotto) {
            int matchingCount = countMatchingNumbers(lotto.getLottoNumbers(), winNumbers);
            increaseWin(matchingCount, isBonusMatched(lotto, bonusNumber));
        }
    }
    private void increaseWin(int matchingCount, boolean bonusMatched) {
        int lottoPrize = 6 - matchingCount;
        /* 3개 이상 일치부터 상금이 존재함. 5등은 보너스 번호를 확인해야 한다. */
        if (matchingCount == 5 && !bonusMatched) {
            lottoPrize += 1;
        } else if (matchingCount == 3 || matchingCount == 4) {
            lottoPrize += 1;
        }
        if (lottoPrize > 4) {
            return ;
        }
        int updatedValue = this.lottoResult.get(lottoPrize) + 1;
        this.lottoResult.set(lottoPrize, updatedValue);
    }
    private static boolean isBonusMatched(Lotto lotto, int bonusNumber) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }
    /* 유저의 로또 번호가 당첨 번호와 얼마나 일치하는지 반환 */
    private static int countMatchingNumbers(List<Integer> lotto, List<Integer> winNumbers) {
        int count = 0;

        for (int number : lotto) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    private void initLottoResult() {
        int size = 5;
        int initialValue = 0;
        Integer[] array = new Integer[size];
        Arrays.fill(array, initialValue);
        this.lottoResult = Arrays.asList(array);
    }
}
