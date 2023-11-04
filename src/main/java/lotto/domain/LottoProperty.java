package lotto.domain;

/**
 * @author 민경수
 * @description lotto property
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoProperty {

    private Integer pricePerLotto;
    private Integer lottoMinimumRangeFrom;
    private Integer lottoMaximumRangeTo;
    private Integer lottoSize;

    public LottoProperty(Integer pricePerLotto, Integer lottoMinimumRangeFrom, Integer lottoMaximumRangeTo,
                         Integer lottoSize) {
        this.pricePerLotto = pricePerLotto;
        this.lottoMinimumRangeFrom = lottoMinimumRangeFrom;
        this.lottoMaximumRangeTo = lottoMaximumRangeTo;
        this.lottoSize = lottoSize;
    }

    public Integer pricePerLotto() {
        return pricePerLotto;
    }

    public Integer lottoMinimumRangeFrom() {
        return lottoMinimumRangeFrom;
    }

    public Integer lottoMaximumRangeTo() {
        return lottoMaximumRangeTo;
    }

    public Integer lottoSize() {
        return lottoSize;
    }

}