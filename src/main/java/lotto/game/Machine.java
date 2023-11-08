package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.type.WinningRanking;

import java.util.*;
import java.util.function.Predicate;

import static lotto.game.UserConsole.showLottos;

public class Machine {

    private static final long PRICE = 1000;
    private static final int EMPTY = 0;
    private final int purchasedLottoCount;

    public Machine(long money) {
        validateMoneyByAmount(money);
        this.purchasedLottoCount = (int) (money / PRICE);
    }

    public long getPurchasedLottoCount() {
        return purchasedLottoCount;
    }

    private void validateMoneyByAmount(long money) {
        if (money % PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int remainedLottoCount = this.purchasedLottoCount;

        while (remainedLottoCount > EMPTY) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();

            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            showLottos(lotto);
            remainedLottoCount--;
        }
        return lottos;
    }

    public Map<Double, Integer> createMatchResult(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<Double, Integer> matchResult = new HashMap<>();
        List<WinningRanking> winningRanking = new ArrayList<>(List.of(WinningRanking.values()));
        for (WinningRanking ranking : winningRanking) {
            matchResult.put(ranking.getPrize(), 0);
        }
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winningNumber, lotto);
            boolean isBonusMatch = lotto.getNumbers().contains(winningNumber.bonusNumber());
            if (matchCount == 6) {
                int count = matchResult.get(WinningRanking.FIRST_PLACE.getPrize());
                matchResult.put(WinningRanking.FIRST_PLACE.getPrize(), count + 1);
            } else if (matchCount == 5 && isBonusMatch) {
                int count = matchResult.get(WinningRanking.SECOND_PLACE.getPrize());
                matchResult.put(WinningRanking.SECOND_PLACE.getPrize(), count + 1);
            } else if (matchCount == 5 & !isBonusMatch) {
                int count = matchResult.get(WinningRanking.THIRD_PLACE.getPrize());
                matchResult.put(WinningRanking.THIRD_PLACE.getPrize(), count + 1);
            } else if (matchCount == 4) {
                int count = matchResult.get(WinningRanking.FOURTH_PLACE.getPrize());
                matchResult.put(WinningRanking.FOURTH_PLACE.getPrize(), count + 1);
            } else if (matchCount == 3) {
                int count = matchResult.get(WinningRanking.FIFTH_PLACE.getPrize());
                matchResult.put(WinningRanking.FIFTH_PLACE.getPrize(), count + 1);
            }
        }
        return matchResult;
    }

    public int getMatchCount(WinningNumber winningNumber, Lotto lotto) {
        int matchCount = lotto.getNumbers()
                .stream()
                .filter(o -> winningNumber.firstWinningNumber().stream()
                        .anyMatch(Predicate.isEqual(o)))
                .toList()
                .size();
        return matchCount;
    }

    public double calculateInvestmentResult(Map<Double, Integer> matchResult) {
        double investmentSum = 0;
        Set<Double> keySet = matchResult.keySet();
        for (double key : keySet) {
            investmentSum += (key * (matchResult.get(key)));
        }
        return investmentSum / (PRICE * purchasedLottoCount) * 100;
    }

}
