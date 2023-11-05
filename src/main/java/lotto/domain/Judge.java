package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.Rank;

public class Judge {
    public List<Rank> createRanks(List<SameNumber> sameNumbers) {
        return sameNumbers.stream()
                .map(SameNumber::createRank)
                .collect(Collectors.toList());
    }
}
