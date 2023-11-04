package lotto.domain;
import camp.nextstep.edu.missionutils.Console;
import java.awt.font.NumericShaper;

public class InputAmount {
    private static final int Lotto_Cost = 1000;
    private final int Lottos = 0;

    public InputAmount(String Input_cash) {
        int Input_first_cash = handlingNumber(Input_cash);

    }

    private static int handlingNumber(String Input_cash) throws IllegalArgumentException{
        try{
            return Integer.parseInt(Input_cash);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
