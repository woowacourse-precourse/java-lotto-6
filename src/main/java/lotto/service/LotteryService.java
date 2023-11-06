package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.utils.Input;
import lotto.utils.Output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LotteryService {
    private Lotto winningLottery;
    private int bonusNumber;

    public void setWinningLottery() {
        this.winningLottery = Input.readLottery();
        this.bonusNumber = Input.readBonusNumber(winningLottery);
    }

    public List<Lotto> issueLottery() {
        int amount = Input.readPurchaseAmount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = Lotto.generateLottery();
            lottos.add(lotto);
        }

        Output.printLotteries(lottos);
        return lottos;
    }

    public void getWinningResults(List<Lotto> lottos) {
        Map<Prize, Integer> result = setResult();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Prize prize = Prize
                    .checkWinningPrize(countMatchingNumbers(numbers), matchesBonusNumber(numbers));
            result.put(prize, result.get(prize) + 1);
        }
        double winningStatistics = getWinningStatistics(result, lottos.size());

        Output.printResult(result, winningStatistics);
    }

    private double getWinningStatistics(Map<Prize, Integer> result, int lottoAmount) {
        double earningRate = 0.0;

        for (Prize prize : result.keySet()) {
            earningRate =
                    earningRate + ((double) (prize.getReward()) / (lottoAmount * 1000) * (result.get(prize)) * 100);
        }
        return earningRate;
    }

    private int countMatchingNumbers(List<Integer> purchasedNumbers) {
        int matchingNumbers = 0;
        List<Integer> winningLotteryNumbers = this.winningLottery.getNumbers();
        for (int number : purchasedNumbers) {
            if (winningLotteryNumbers.contains(number)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }

    private boolean matchesBonusNumber(List<Integer> purchasedNumbers) {
        return purchasedNumbers.contains(this.bonusNumber);
    }

    private Map<Prize, Integer> setResult() {
        Map<Prize, Integer> result = new LinkedHashMap<>();

        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        return result;
    }
}
