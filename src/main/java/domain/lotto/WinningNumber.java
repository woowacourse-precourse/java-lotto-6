package domain.lotto;

import static global.NumberDefinition.END_INCLUSIVE;
import static global.NumberDefinition.START_INCLUSIVE;

public class WinningNumber {
    private final int number;

    public WinningNumber(int number) {
        validateNumberIsInRange(number);
        this.number = number;
    }

    private void validateNumberIsInRange(int number) {
        if(number < START_INCLUSIVE.getNumber() || number > END_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException("숫자가 범위 밖임");
        }
    }

    public int getNumber() {
        return number;
    }
}
