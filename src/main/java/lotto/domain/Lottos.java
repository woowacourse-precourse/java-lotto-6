package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public MatchingResults matchAll(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        List<MatchingResult> matchingResults = lottos.stream()
                .map((issuedLotto -> issuedLotto.match(winningLotto, bonusLottoNumber)))
                .toList();

        return new MatchingResults(matchingResults);
    }
}
