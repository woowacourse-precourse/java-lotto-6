package lotto;

import static lotto.Constants.*;

public abstract class Input<T> {
    public void save(String readLine) {}
    protected T validate(String readLine) {return null;}
    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }
    protected T translateToValueType(String noEmptyReadLine) {return null;}

    protected void checkBoundary(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_BOUNDARY_ERROR);
        }
    }
}
