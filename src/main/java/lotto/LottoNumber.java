package lotto;

public class LottoNumber {

    private int number;

    public LottoNumber(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 숫자는 1부터 45까지 입니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
