package lotto.util;

import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lottoresult.LottoResult;

public class LottoResultData {
    private final int numberOfSame;
    private final long prizeMoney;
    private final int count;
    private final boolean isSecond;

    public LottoResultData(LottoResult lottoResult, LottoResultsDto lottoResultsDto) {
        this.numberOfSame = lottoResult.getNumberOfSame();
        this.prizeMoney = lottoResult.getPrizeMoney();
        this.count = lottoResultsDto.getLottoResultsData().get(lottoResult);
        this.isSecond = lottoResult.isSecond();
    }

    public int getNumberOfSame() {
        return numberOfSame;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isSecond() {
        return isSecond;
    }
}
