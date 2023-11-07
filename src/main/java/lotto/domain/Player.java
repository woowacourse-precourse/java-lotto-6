package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Player {
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> winningDetails = new HashMap<>();

    {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningDetails.put(rank, 0));
    }

    public Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> checkWinning(Lotto winningNumber, int bonusNumber) {
        int correctCount;
        boolean isBonus;
        Rank rank;

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i).getNumbers();

            correctCount = checkCorrectCount(lotto, winningNumber.getNumbers());
            isBonus = checkCorrectBonus(lotto, bonusNumber);

            rank = Rank.findByRank(correctCount, isBonus);
            winningDetails.put(rank, winningDetails.get(rank) + 1);
        }
        return winningDetails;
    }

    private boolean checkCorrectBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private int checkCorrectCount(List<Integer> lotto, List<Integer> winningNumber) {
        return (int) IntStream.range(0, winningNumber.size())
                .filter(index -> lotto.contains(winningNumber.get(index)))
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
