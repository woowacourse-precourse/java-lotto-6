package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningAnalyzer {
    private final AnswerLottos answerLottos;

    public WinningAnalyzer(AnswerLottos answerLottos) {
        this.answerLottos = answerLottos;
    }

    public Map<Prize, Integer> compare(LottoTicket lottoTicket) {
        List<Result> result = answerLottos.match(lottoTicket);
        Results results = new Results(result);

        return results.getPrizeResult();
    }
}
