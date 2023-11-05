package lotto.iomanangers;

import lotto.exception.LottoApplicationException;

public class ExceptionOutputManager {
    public void printException(LottoApplicationException e) {
        System.out.println(e.getMessage());
    }
}
