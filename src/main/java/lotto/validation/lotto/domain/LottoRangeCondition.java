package lotto.validation.lotto.domain;


import java.util.List;
import lotto.validation.ValidationCondition;

public class LottoRangeCondition extends ValidationCondition {
    private int lottoMinValue;
    private int lottoMaxValue;
    private static final String EXCEPTION_MSG = "입력 값의 범위를 확인해주세요.";

    public LottoRangeCondition(int lottoMinValue, int lottoMaxValue) {
        this.lottoMinValue = lottoMinValue;
        this.lottoMaxValue = lottoMaxValue;
    }

    @Override
    protected void validateCondition(Object obj) {
        List<Integer> lottoNumbers = (List) obj;

        for (Integer lottoNum : lottoNumbers) {
            if(!isLottoNumInRange(lottoNum)){
                throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
            }
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof List;
    }

    private boolean isLottoNumInRange(int lottoNum) {
        return lottoMinValue <= lottoNum && lottoMaxValue >= lottoNum;
    }


}
