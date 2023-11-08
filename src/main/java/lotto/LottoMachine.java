package lotto;

import lotto.enums.LottoInfo;

import static lotto.Input.getNaturalNumber;

public class LottoMachine {
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;
    private final int NUMBERS_PER_LOTTO;
    private final int LOTTO_PRICE;

    LottoMachine() {
        this.MIN_NUMBER = LottoInfo.MIN_NUMBER.getNumber();
        this.MAX_NUMBER = LottoInfo.MAX_NUMBER.getNumber();
        this.NUMBERS_PER_LOTTO = LottoInfo.NUMBERS_PER_LOTTO.getNumber();
        this.LOTTO_PRICE = LottoInfo.LOTTO_PRICE.getNumber();
    }

    public void run() {
    }

    public int setLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int number = getNaturalNumber();
                Validation.validateMultipleOfLottoPrice(number);
                return number/LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
