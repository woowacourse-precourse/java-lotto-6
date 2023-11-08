package lotto;

public class LottoException extends IllegalArgumentException{
    public LottoException(lotto.enums.LottoException e){
        super(e.getPrompt());
    }
}
