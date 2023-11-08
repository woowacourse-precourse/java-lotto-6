package lotto.model;

import lotto.Lotto;

import java.util.List;

public class User {
    private List<Lotto> lottos;

    private User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static User of(List<Lotto> lottos) {
        return new User(lottos);
    }

    public List<LottoResult> checkLottosResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.toLottoResult(winningNumbers))
                .toList();
    }
}
