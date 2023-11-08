package lotto.core.iomanangers;

import lotto.core.exception.LottoApplicationException;

public class ConsoleOutputManager{

    public static void printOut(String input) {
        System.out.println(input);
    }

    public static void printException(LottoApplicationException e) {
        System.out.println(e.getMessage());
    }
}
