package lotto.controller;

import lotto.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PrizeController {
    PrizeMoney prizeMoney;
    WinnerLotto winnerLotto = new WinnerLotto();

    public double rateOfReturn(int buyMoney) {
        return (winnerLotto.getPrizeSumMoney() / (double) buyMoney) * 100;
    }

    public void calculateLottoPrize() {
        HashMap<PrizeMoney, Integer> lottoRankStore = winnerLotto.getLottoRankStore();
        int[] lottoPrizeCount = winnerLotto.getLottoPrizeCount();
        for (int i = 3; i < 8; i++) {
            winnerLotto.setPrizeSumMoney(findMoney(i, lottoPrizeCount[i]));
        }
    }

    public int findMoney(int matchNum, int count) {
        for (PrizeMoney p : winnerLotto.getLottoRankStore().keySet()) {
            if (p.getMatchNum() == matchNum) {
                return count * p.getPrizeMoney();
            }
        }
        return 0;
    }

    public void createLottoRankStore() {
        HashMap<PrizeMoney, Integer> lottoRankStore = new HashMap<>();
        lottoRankStore.put(PrizeMoney.FIRST_PRIZE, 0);
        lottoRankStore.put(PrizeMoney.SECOND_PRIZE, 0);
        lottoRankStore.put(PrizeMoney.THIRD_PRIZE, 0);
        lottoRankStore.put(PrizeMoney.FOURTH_PRIZE, 0);
        lottoRankStore.put(PrizeMoney.FIFTH_PRIZE, 0);
        for (PrizeMoney p : lottoRankStore.keySet()) {
            System.out.println("PrizeMatchNum: " + p.getMatchNum());
        }
        winnerLotto.setLottoRankStore(lottoRankStore);
        Set<PrizeMoney> set = lottoRankStore.keySet();
    }

    public void comparePrizeNumToLottoNum(PrizeLotto prizeLotto, UserLotto userLotto) {
        //배열을 생성해서 로또마다 몇개 맞췄는지 배열에 인덱스로 장
        //예로 3개 맞으면 인덱스 3을 하나 증
        int[] arr = new int[8];
        for (Lotto lo : userLotto.getUsersLotto()) {
            arr[compareLottoAndPrize(lo, prizeLotto)]++;
        }
        winnerLotto.setLottoPrizeCount(arr);
        for (int i : winnerLotto.getLottoPrizeCount()) {
            System.out.print(i + " ");
        }
    }

    public int compareLottoAndPrize(Lotto lo, PrizeLotto prizeLotto) {
        int count = 0;
        List<Integer> prizeLottoNum = prizeLotto.getPrizeNumbers();
        int bonusNum = prizeLotto.getBonusNum();
        for (int i : prizeLottoNum) {
            if (lo.getNumbers().contains(i)) {
                count++;
            }
        }
        if (count == 5) {
            if (lo.getNumbers().contains(bonusNum)) {
                count = 7;
            }
        }
        return count;
    }
}
