package lotto;

import static lotto.Constants.EMPTY;
import static lotto.Constants.GAP;
import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.Constants.NUMBER_BOUNDARY_ERROR;

import java.util.List;

public class Input<T> {

    public void save(String readLine) {}

    protected T validate(String readLine) {return null;}

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll(GAP, EMPTY);
    }

    protected void checkDigit(String readLine) {}

    protected T translateToValueType(String noEmptyReadLine) {return null;}

    protected void checkBoundary(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_BOUNDARY_ERROR);
        }
    }
}
