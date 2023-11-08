package lotto.exception;

public class LottoNumberRangeException {
    public static void NumberRangeException(int number){
        if (!(1<=number&&number<=45)){
            System.out.println("[ERROR]1~45사이만 입력가능합니다 다시 입력하세요");
            throw new NumberFormatException("[ERROR]1~45사이만 입력가능합니다");
        }
    }
}