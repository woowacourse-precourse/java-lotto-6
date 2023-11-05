package lotto.domain;

import lotto.constant.LottoRank;

import java.util.EnumMap;

public class Result {

    private final EnumMap<LottoRank, Integer> map;

    public Result(EnumMap<LottoRank, Integer> map) {
        this.map = map;
    }

}
