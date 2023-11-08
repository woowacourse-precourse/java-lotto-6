package lotto.domain;

import lotto.common.LottoFinalConsts;
import net.bytebuddy.pool.TypePool;

import java.util.Arrays;
import java.util.Collections;

public enum LottoRank implements LottoFinalConsts{

    FIRST(LOTTO_FIRST, LOTTO_FIRST_RETURN, LOTTO_FIRST_PRINT),
    SECOND(LOTTO_SECOND, LOTTO_SECOND_RETURN, LOTTO_SECOND_PRINT),
    THIRD(LOTTO_THIRD, LOTTO_THIRD_RETURN, LOTTO_THIRD_PRINT),
    FOURTH(LOTTO_FOURTH, LOTTO_FOURTH_RETURN, LOTTO_FOURTH_PRINT),
    FIFTH(LOTTO_FIFTH, LOTTO_FIFTH_RETURN, LOTTO_FIFTH_PRINT);

    private String sameCount;
    private int lottoReturn;
    private String lottoResultPrint;

    LottoRank(String sameCount, int lottoReturn, String lottoResultPrint){
        this.sameCount = sameCount;
        this.lottoReturn = lottoReturn;
        this.lottoResultPrint = lottoResultPrint;
    }

    public static LottoRank findByRank(String rank){
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.sameCount.equals(rank))
                .findAny()
                .orElse(null);
    }

    public int getLottoReturn(){
        return lottoReturn;
    }

    public String getLottoResultPrint(){
        return lottoResultPrint;
    }

}
