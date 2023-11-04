package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.service.InputService.*;
import static lotto.domain.constant.NumberConstant.*;

public class LottoService {
    public void run() {
        Long expense = readExpense();
        int ticketNum = convertToTicketNum(expense);
        List<Lotto> randomLottos = Lotto.createRandomLottos(ticketNum);

        Lotto winLotto = new Lotto(readWinNumbers());
        int bonusNumber = readBonusNumber();

        Map<MatchResult, Integer> winResult = computeWin(randomLottos, winLotto, bonusNumber);
    }

    private int convertToTicketNum(Long expense) {
        return (int) (expense / LOTTO_PRICE);
    }

    private Map<MatchResult, Integer> computeWin(List<Lotto> randomLottos, Lotto winLotto, int bonusNumber) {
        Map<MatchResult, Integer> totalResult = initEnumMap();

        for (Lotto randomLotto : randomLottos) {
            MatchResult matchResult = Lotto.match(randomLotto, winLotto);

            totalResult.compute(matchResult, (k, v) -> v + MATCHRESULT_INCREMENT_NUM);
        }

        return totalResult;
    }

    private Map<MatchResult, Integer> initEnumMap() {
        EnumMap<MatchResult, Integer> enumMap = new EnumMap<MatchResult, Integer>(MatchResult.class);

        for (MatchResult result : MatchResult.values())
            enumMap.put(result, 0);

        return initEnumMap();
    }
}
