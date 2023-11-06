package lotto.core.iomanangers;

import lotto.core.exception.LottoApplicationException;

public class ExceptionOutputManager {
    public static void printException(LottoApplicationException e) {
        System.out.println(e.getMessage());
    }
}
