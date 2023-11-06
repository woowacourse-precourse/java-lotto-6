package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.Configuration;
import lotto.domain.Lotto;
import lotto.domain.WinningAmount;
import lotto.domain.WinningLotto;

public class LottoService {

    private LottoService() {
    }

    public static List<Lotto> purchaseLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = amount / Configuration.LOTTO_PRICE;

        for (int index = 0; index < lottoCount; index++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public static int getRankOfLotto(Lotto lotto, WinningLotto winningLotto) {
        Set<Integer> matchNumbers;
        boolean bonusMatch;
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        matchNumbers = lottoNumbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toSet());
        bonusMatch = lottoNumbers.contains(bonusNumber);

        return matchInfoToRank(matchNumbers, bonusMatch);
    }

    public static int rankToAmount(int rank) {
        int amount = WinningAmount.DEFAULT.getValue();

        if (rank >= 1 && rank <= 5) {
            amount = WinningAmount.values()[rank].getValue();
        }

        return amount;
    }

    public static double winningRate(int purchaseAmount, int winningMoney) {
        return (double) winningMoney / purchaseAmount;
    }

    private static int matchInfoToRank(Set<Integer> matchNumbers, boolean bonusMatch) {
        final int MIN_WINNING_SIZE = 3;
        int matchSize = matchNumbers.size();
        int rank;

        if (matchSize < MIN_WINNING_SIZE) {
            return 0;
        }

        rank = Configuration.LOTTO_LENGTH - matchSize + 1;
        if (matchSize <= 5
                && !(matchSize == 5 && bonusMatch)) {
            rank++;
        }

        return rank;
    }
}
