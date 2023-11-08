package lotto.domain;

import lotto.common.LottoFinalConsts;
import net.bytebuddy.pool.TypePool;

import java.util.Arrays;
import java.util.Collections;

public enum LottoRank implements LottoFinalConsts{

    FIRST(LOTTO_FIRST, LOTTO_FIRST_RETURN),
    SECOND(LOTTO_SECOND, LOTTO_SECOND_RETURN),
    THIRD(LOTTO_THIRD, LOTTO_THIRD_RETURN),
    FOURTH(LOTTO_FOURTH, LOTTO_FOURTH_RETURN),
    FIFTH(LOTTO_FIFTH, LOTTO_FIFTH_RETURN);

    private String sameCount;
    private int lottoReturn;

    LottoRank(String sameCount, int lottoReturn){
        this.sameCount = sameCount;
        this.lottoReturn = lottoReturn;
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

}
