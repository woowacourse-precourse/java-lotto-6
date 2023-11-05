package lotto.core.iomanangers;

import lotto.core.exception.LottoApplicationException;

public class ExceptionOutputManager {
    public void printException(LottoApplicationException e) {
        System.out.println(e.getMessage());
    }
}
