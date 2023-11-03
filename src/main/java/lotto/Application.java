package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.PriceInputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String s = Console.readLine();
        PriceInputHandler priceInputHandler = new PriceInputHandler();
        priceInputHandler.validate(s);
    }
}
