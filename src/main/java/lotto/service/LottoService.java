package lotto.service;

import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.AnswerLotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<Rank> findWinningResult(List<Lotto> lottos, AnswerLotto answerLotto) {
        return lottos.stream()
                .map(lotto -> lotto.calculateLottoWinnings(answerLotto))
                .collect(Collectors.toList());
    }

    public double findRateOfReturn(List<Rank> ranks) {
        int purchasePrice = ranks.size() * LottoConstant.LOTTO_TICKET_PRICE;
        double totalWinningPrice = ranks.stream()
                .mapToDouble(rank -> rank.getWinningPrice())
                .sum();

        double rate = totalWinningPrice / purchasePrice * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
