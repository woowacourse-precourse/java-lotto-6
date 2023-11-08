package lotto.dto;

import lotto.domain.WinningLottoTable;

public class LottoRanksDto {

    private WinningLottoTable winningLottoTable;
    private long lottoCnt;

    private LottoRanksDto() {}

    public static LottoRanksDto valueOf(WinningLottoTable winningLottoTable, long lottoCnt) {
        LottoRanksDto lottoRanksDto = new LottoRanksDto();
        lottoRanksDto.winningLottoTable = winningLottoTable;
        lottoRanksDto.lottoCnt = lottoCnt;
        return lottoRanksDto;
    }

    public WinningLottoTable getWinningLottoTable() {
        return winningLottoTable;
    }

    public long getLottoCnt() {
        return lottoCnt;
    }
}
