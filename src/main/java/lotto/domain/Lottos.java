package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private Player player;
    private LottoResult lottoResult = LottoResult.NONE;
    private int total = 0;

    public Lottos(List<Integer> winningNumber, int bonusNumber, Player player) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.player = player;
    }

    public int classifyLottoGrade() {
        for (int i = 0; i < player.getLotteries().size(); i++) {
            List<Integer> result = calculateMatchNumbers(i);
            int size = result.size();
            if (size == 5 && isBonusNumberIncluded(i)) {
                size += 5;
            }
            this.lottoResult = LottoResult.initiateLottoResult(size);
            System.out.println(size);
        }
        return this.total;
    }

    private List<Integer> calculateMatchNumbers(int index) {
        return winningNumber.stream()
                .filter(num -> player.getLotteries()
                .get(index).getNumbers().stream()
                .anyMatch(Predicate.isEqual(num)))
                .collect(Collectors.toList());
    }

    private boolean isBonusNumberIncluded(int index) {
        return player.getLotteries().get(index).getNumbers().contains(bonusNumber);
    }
}
