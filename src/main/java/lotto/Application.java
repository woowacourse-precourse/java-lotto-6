package lotto;

import lotto.domain.Numbers;

public class Application {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.createLottoNumbers();
    }
}
