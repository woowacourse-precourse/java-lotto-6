package Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class ExceptionHandler {
    public void checkPriceUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액이 1,000 단위가 아닐 때 예외가 발생해야 합니다.");
        }
    }

    public void checkTypePriceUnit(String str) {}
}
