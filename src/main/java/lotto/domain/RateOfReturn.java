package lotto.domain;

import lotto.constants.GameNumberConstants;

public class RateOfReturn {
    private static final float MAX_RATE_OF_RETURN = 100f;
    private static final float MIN_RATE_OF_RETURN = 0f;
    private static final String RATE_OF_RETURN_SHOULD_BE_IN_RANGE = "[ERROR] 수익률은 %.1f이상 %.1f이하이어야 합니다.";

    private float rateOfReturn;

    public RateOfReturn(float rateOfReturn) {
        validator(rateOfReturn);
        this.rateOfReturn = rateOfReturn;
    }

    private void validator(float rateOfReturn) {
        if (MIN_RATE_OF_RETURN <= rateOfReturn && rateOfReturn <= MAX_RATE_OF_RETURN) {
            return;
        }
        throw new IllegalArgumentException(String.format(RATE_OF_RETURN_SHOULD_BE_IN_RANGE, MIN_RATE_OF_RETURN, MAX_RATE_OF_RETURN));
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }
}
