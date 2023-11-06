package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count, LottoNumbers lottoNumbers) {
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoNumbers.generateNumbers()))
                .collect(Collectors.toList());
    }

    public void compareWithWinningNumbers(Lotto winningNumbers, int inputBonusNumber) {
        for (Lotto lotto : lottos) {
            long matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = checkBonusMatch(lotto, inputBonusNumber);
            updateWinningRank(matchCount, bonusMatch);
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

    private void updateWinningRank(long matchCount, boolean bonusMatch) {
        for (WinningRank rank : WinningRank.values()) {
            if (rank.isMatch(matchCount, bonusMatch)) {
                rank.addWinCount();
                break;
            }
        }
    }

    public void printLottoNumbers() {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}
