package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    public static List<Lotto> generateLottos(int number) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<Integer> makeLottoResult(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        List<Integer> winningCounts = new ArrayList<>();
        int size = 5;
        List<Integer> zeros = Collections.nCopies(size, 0);
        winningCounts.addAll(zeros);
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchingNumber = 0;
            boolean bonusFlag = false;
            for (Integer lottoNumber : lottoNumbers) {
                if (winningNumbers.contains(lottoNumber)) {
                    matchingNumber++;
                }
                if (lottoNumber == bonusNumber) {
                    bonusFlag = true;
                }
            }
            if (matchingNumber == 3) {
                winningCounts.set(0, winningCounts.get(0) + 1);
            }
            if (matchingNumber == 4) {
                winningCounts.set(1, winningCounts.get(1) + 1);
            }
            if (matchingNumber == 5) {
                winningCounts.set(2, winningCounts.get(2) + 1);
            }
            if (matchingNumber == 6) {
                if (bonusFlag) {
                    winningCounts.set(3, winningCounts.get(3) + 1);
                }
            }
            if (matchingNumber == 6) {
                if (!bonusFlag) {
                    winningCounts.set(4, winningCounts.get(4) + 1);
                }
            }
        }
        return winningCounts;
    }

    public static double calculateEarningRate(int purchaseAmount, List<Integer> rewards, List<Integer> counts) {
        int iterTotalNumber = rewards.size();
        int totalEarning = 0;
        for (int i = 0; i < iterTotalNumber; i++) {
            totalEarning += rewards.get(i) * counts.get(i);
        }
        return (double) Math.round((double) totalEarning * 1000 / purchaseAmount)/10;
    }

}
