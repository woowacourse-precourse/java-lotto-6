package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoPrice;
import lotto.model.LottoRank;

import java.util.List;

import static lotto.constant.Constant.*;

public class LottoService {

    public void createLotto(int lottoCount, List<Lotto> lottos) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_SIZE);
            lottos.add(new Lotto(numbers));
        }
    }

    public int[] calculateResult(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int matchCount = calculateMatchCount(winNumbers, numbers);
            int matchBonusCount = calculateBonusCount(bonusNumber, numbers);
            LottoRank lottoRank = LottoRank.matchLottoRank(matchCount, matchBonusCount);
            result[lottoRank.getRank()]++;
        }
        return result;
    }

    public int calculateTotalWinPrice(int[] result) {
        int totalWinPrice = 0;
        for (int i = 0; i < result.length; i++) {
            totalWinPrice += LottoPrice.matchLottoPrice(i).getPrice() * result[i];
        }
        return totalWinPrice;
    }

    private int calculateBonusCount(int bonusNumber, List<Integer> numbers) {
        int matchBonusCount = 0;
        if (numbers.contains(bonusNumber)) {
            matchBonusCount++;
        }
        return matchBonusCount;
    }

    private int calculateMatchCount(List<Integer> winNumbers, List<Integer> numbers) {
        int matchCount = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    
}
