package lotto.domain;

import static lotto.message.MessageConstants.ZERO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public void compareWithWinningNumbers(LottoBuyer lottoBuyer, Lotto winningNumbers, int inputBonusNumber) {
        for (Lotto lotto : lottos) {
            long matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = checkBonusMatch(lotto, inputBonusNumber);
            updateWinningRank(lottoBuyer, matchCount, bonusMatch);
        }
    }

    private long countMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        return winningNumbers.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private boolean checkBonusMatch(Lotto lotto, int inputBonusNumber) {
        return lotto.getNumbers().contains(inputBonusNumber);
    }

    private void updateWinningRank(LottoBuyer lottoBuyer, long matchCount, boolean bonusMatch) {
        for (WinningRank rank : WinningRank.values()) {
            if (rank.isMatch(matchCount, bonusMatch)) {
                lottoBuyer.addWinCount(rank);
                break;
            }
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
