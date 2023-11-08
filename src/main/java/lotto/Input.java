package lotto;

import static lotto.Constants.NUMBER_BOUNDARY_ERROR;

public class Input<T> {

    public void save(String readLine) {}

    protected T validate(String readLine) {return null;}

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    protected void checkDigit(String readLine) {}

    protected T translateToValueType(String noEmptyReadLine) {return null;}

    protected void checkBoundary(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_BOUNDARY_ERROR);
        }
    }
}
