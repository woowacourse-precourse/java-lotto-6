package lotto.iomanangers;

import lotto.exception.IllegalNumberTypeException;
import lotto.exception.LottoApplicationException;

public class ExceptionOutputManager {
    public void throwException(LottoApplicationException lottoApplicationException){
        try{

        }catch (LottoApplicationException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
