package lotto.exception;

import java.util.NoSuchElementException;
import lotto.exception.LottoApplicationException;

public class ExceptionHandler {
    public void handleException(LottoApplicationException e){
        try{
            System.out.println(e.getMessage());
        }catch (LottoApplicationException exception){
            throw new NoSuchElementException();
        }
    }
}
