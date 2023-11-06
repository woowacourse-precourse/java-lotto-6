package lotto.core.lotto;

import lotto.core.enums.WinningChartEnum;

public class ScratchedLottoTicket {
    private final LottoTicket lottoTicket;
    private final Integer matchCount;
    private final WinningChartEnum winningChartEnum;

    public ScratchedLottoTicket(LottoTicket lottoTicket, Integer matchCount, Boolean bonus) {
        this.lottoTicket = lottoTicket;
        this.matchCount = matchCount;
        this.winningChartEnum = WinningChartEnum.valueOf(matchCount, bonus);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public WinningChartEnum getWinningChartEnum() {
        return winningChartEnum;
    }
}
