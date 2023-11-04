package lotto.lotto;

import lotto.enums.WinningChartEnum;

public class ScratchedLottoTicket {
    private final LottoTicket lottoTicket;
    private final Integer matchCount;
    private final Boolean bonus;
    private final WinningChartEnum winningChartEnum;

    public ScratchedLottoTicket(LottoTicket lottoTicket, Integer matchCount, Boolean bonus) {
        this.lottoTicket = lottoTicket;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.winningChartEnum = WinningChartEnum.valueOf(matchCount, bonus);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Boolean getBonus() {
        return bonus;
    }

    public WinningChartEnum getWinningChartEnum() {
        return winningChartEnum;
    }
}
