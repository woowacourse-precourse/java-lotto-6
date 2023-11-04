package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.List;
import java.util.Map;

import static lotto.service.InputService.*;
import static lotto.service.NumberService.*;

public class LottoService {
    public void run() {
        int lottoTicketNum = computeLottoTicketNum();

        List<Lotto> randomLottos = Lotto.createRandomLottos(lottoTicketNum);
        Lotto winLotto = new Lotto(readWinNumbers());
        int bonusNum = readBonusNumber();

        Map<MatchResult, Integer> result = computeResult(randomLottos, winLotto, bonusNum);
        long totalPrize = computeTotalPrize(result);

        double margin = computeMargin(lottoTicketNum, totalPrize);
    }
}
