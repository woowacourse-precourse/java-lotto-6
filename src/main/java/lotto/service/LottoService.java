package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> buyLottery(Integer purchasePrice) {
        List<Lotto> lottery = new ArrayList<>();
        Integer numOfLotto = purchasePrice / 1000;

        for (Integer i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottery.add(new Lotto(numbers));
        }
        return lottery;
    }

    public Map<Integer, Integer> matchLotteryWinningNumber(List<Lotto> lottery, List<Integer> winningNumber, Integer bonusNumber) {
        Map<Integer, Integer> resultCount = new HashMap<>();
        for (Lotto lotto : lottery) {
            int rank = matchLottoWinningNumber(lotto, winningNumber, bonusNumber);
            System.out.println(rank);
            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }
        return resultCount;
    }

    private int matchLottoWinningNumber(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int result = 0;
        boolean matchBonusNumber = false;
        for (Integer lottoNumber : lotto.getNumbers()) {
            for (Integer winningNumber : winningNumbers) {
                if (lottoNumber.equals(winningNumber)) {
                    result++;
                }
            }
            if (lottoNumber.equals(bonusNumber)) {
                matchBonusNumber = true;
            }
        }

        if (result == 6) {
            return 1;
        }
        if (result == 5 && matchBonusNumber) {
            return 2;
        }
        if (result == 5) {
            return 3;
        }
        if (result == 4) {
            return 4;
        }
        if (result == 3) {
            return 5;
        }
        return 0;
    }
}
