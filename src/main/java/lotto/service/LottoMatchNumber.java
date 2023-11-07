package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMatchNumber {
    private static final int lottoSize = 6;
    private final List<Match> matches = new ArrayList<>();

    public List<Match> lottoMatch(List<Lotto> purchasedLottoes, Lotto winningNumber, BonusNumber bonusNumber) {
        getResult(purchasedLottoes, winningNumber, bonusNumber);
        Collections.sort(matches);
        return matches;
    }

    private void getResult(List<Lotto> purchasedLottoes, Lotto winningNumber, BonusNumber bonusNumber) {
        for (int i = 0; i < purchasedLottoes.size(); i++) {
            matchNumber(purchasedLottoes.get(i), winningNumber, bonusNumber);
        }
    }

    private void matchNumber(Lotto purchasedLotto, Lotto winningNumber, BonusNumber bonusNumber) {
        int count = 0;
        boolean bonus = matchBonus(purchasedLotto, bonusNumber);
        for (int i = 0; i < lottoSize; i++) {
            if (purchasedLotto.getNumbers().contains(winningNumber.getNumbers().get(i))) {
                count++;
            }
        }
        matches.add(Match.match(count, bonus));
    }

    private boolean matchBonus(Lotto purchasedLotto, BonusNumber bonusNumber) {
        return purchasedLotto.getNumbers().contains(bonusNumber.getBonus());
    }
}
