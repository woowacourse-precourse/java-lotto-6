package lotto;

public class LottoService {
    public Money changeStringToInt(String str) {
        try{
            return new Money(Integer.parseInt(str));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
    }
}
