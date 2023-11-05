package lotto;

public class LottoNumber extends Number{

    private int value;
    private boolean isBonus;
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;
    private LottoNumber(int value, boolean isBonus){
        validateNumberValue(value);
        this.value = value;
        this.isBonus = isBonus;
    }

    private void validateNumberValue(int value){
        if (value > MAX_VALUE || value < MIN_VALUE){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
