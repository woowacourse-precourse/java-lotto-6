package lotto.domain;

import lotto.constants.Ranks;

import java.util.List;

public class Rank {
    public static List<Ranks> calculateRanks(
            LottoRound answer,
            List<Lotto> inputs
    ) {
        return inputs
                .stream()
                .map(input ->
                        Ranks.findBy(
                                getMatchCount(input.getNumbers(), answer.getLotto().getNumbers()),
                                input.getNumbers().contains(answer.getBonus())
                        )
                )
                .toList();
    }

    private static int getMatchCount(
            List<Integer> from,
            List<Integer> to
    ) {
        return from
                .stream()
                .filter(to::contains)
                .toArray()
                .length;
    }
}
