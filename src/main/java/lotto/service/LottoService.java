package lotto.service;

import lotto.MATCHING;
import lotto.domain.Lotto;
import lotto.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LottoService {

    public static final Integer MIN_ANSWER_COUNT = 3;
    public static final Integer ANSWER_COUNT_THREE = 3;
    public static final Integer ANSWER_COUNT_FOUR = 4;
    public static final Integer ANSWER_COUNT_FIVE = 5;
    public static final Integer ANSWER_COUNT_FIVE_BONUS = 7;
    public static final Integer ANSWER_COUNT_SIX = 6;
    public static final Utils utils = new Utils();

    public List<Lotto> createLotto(Integer purchaseAmount) {

        List<Lotto> Lottoes = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {

            List<Integer> lottoNumbers = utils.generateRandomNumbers();
            Lottoes.add(new Lotto(lottoNumbers));
        }

        return Lottoes;
    }

    public HashMap<Integer, Integer> getResult(List<Lotto> lottoes, Integer bonusNumber, HashSet<Integer> winningNumbers) {

        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = MIN_ANSWER_COUNT; i < 8 ; i++) {
            result.put(i,0);
        }

        for (Lotto lotto : lottoes) {

            int count = lotto.countWinningNumber(winningNumbers);
            boolean containBonusNumber = lotto.checkContainNumber(bonusNumber);
            initResult(count, containBonusNumber, result);
        }

        return result;
    }

    private void initResult(Integer count, boolean containBonusNumber, HashMap<Integer, Integer> result) {

        if (count < MIN_ANSWER_COUNT) {
            return;
        }

        if (count.equals(ANSWER_COUNT_FIVE) && containBonusNumber) {
            result.put(7, result.get(7) + 1);
            return;
        }

        result.put(count, result.get(count) + 1);
    }

    public double calculateProfitRate(Integer purchaseAmount, HashMap<Integer, Integer> result) {

        int totalPrize = 0;
        int purchaseMoney = purchaseAmount*1000;
        totalPrize += result.get(ANSWER_COUNT_THREE) * MATCHING.MATCH_THREE.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FOUR) * MATCHING.MATCH_FOUR.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FIVE) * MATCHING.MATCH_FIVE.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FIVE_BONUS) * MATCHING.MATCH_FIVE_BONUS.getPrize();
        totalPrize += result.get(ANSWER_COUNT_SIX) * MATCHING.MATCH_SIX.getPrize();

        return (double) totalPrize/purchaseMoney;
    }
}
