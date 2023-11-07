package lotto.domain;

import lotto.domain.dto.output.DrawLottoDto;

import java.util.EnumMap;
import java.util.Map;

import static lotto.domain.DrawResult.*;
import static lotto.domain.LottoStore.LOTTO_PRICE;

public class DrawMachine {
    private final WinningLottoNumbers winningLottoNumbers;

    public DrawMachine(WinningLottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    private DrawResult draw(Lotto userLotto) {
        int matchingCount = winningLottoNumbers.getMatchingCount(userLotto);
        boolean containBonusNumber = winningLottoNumbers.containBonusNumber(userLotto);
        return getResult(matchingCount, containBonusNumber);
    }

    private double getRateOfReturn(Map<DrawResult, Integer> statistic, int size) {
        double spentAmount = size * LOTTO_PRICE;
        double prizeAmount = getPrizeAmount(statistic);

        double rateOfReturn = prizeAmount / spentAmount * 100;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }

    private double getPrizeAmount(Map<DrawResult, Integer> statistic) {
        double prizeAmount = 0;
        for (Map.Entry<DrawResult, Integer> entry : statistic.entrySet()) {
            DrawResult drawResult = entry.getKey();
            Integer count = entry.getValue();
            prizeAmount += drawResult.getPrizeAmount() * count;
        }
        return prizeAmount;
    }

    private Map<DrawResult, Integer> createStatistic() {
        Map<DrawResult, Integer> statistic = new EnumMap<>(DrawResult.class);
        for (DrawResult drawResult : values()) {
            statistic.put(drawResult, 0);
        }
        return statistic;
    }

    public DrawLottoDto drawAllTicket(Lottos lottos) {
        Map<DrawResult, Integer> statistic = createStatistic();
        for (Lotto lottoTicket : lottos.getLottoTickets()) {
            DrawResult drawResult = draw(lottoTicket);
            Integer count = statistic.get(drawResult);
            statistic.replace(drawResult, count + 1);
        }
        return new DrawLottoDto(
                statistic.get(FIRST),
                statistic.get(SECOND),
                statistic.get(THIRD),
                statistic.get(FOURTH),
                statistic.get(FIFTH),
                getRateOfReturn(statistic, lottos.getSize())
        );
    }
}
