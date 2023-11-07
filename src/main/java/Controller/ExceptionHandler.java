package Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class ExceptionHandler {
    public void checkPriceUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException(
                    ExceptionSentence.PRICE_BOUNDARY_ERROR.getMessage()
            );
        }
    }

    public void checkTypePriceUnit(String str) {}
}
