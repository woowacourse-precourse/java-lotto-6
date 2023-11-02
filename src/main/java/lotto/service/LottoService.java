package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.AnswerLotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<Rank> findWinningResult(List<Lotto> lottos, AnswerLotto answerLotto){
        return lottos.stream()
                .map(lotto -> lotto.calculateLottoWinnings(answerLotto))
                .collect(Collectors.toList());
    }
}
