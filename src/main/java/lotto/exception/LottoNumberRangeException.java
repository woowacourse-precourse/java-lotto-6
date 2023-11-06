package lotto.exception;

public class LottoNumberRangeException {
    public static void NumberRangeException(int number){
        if (!(1<=number&&number<=45)){
            throw new NumberFormatException("다시입력하세요");
        }
    }
}
