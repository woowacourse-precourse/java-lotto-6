package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumber {

    private int ticket_number;

    PriceValidation priceValidation;
    private List<Integer> numbers;
    private Lotto lotto;

    public void LottoNumber(int total_lotto_price) {
        priceValidation = new PriceValidation(total_lotto_price);
        ticket_number = total_lotto_price / 1000;
        createNumber(ticket_number);
    }

    public void createNumber(int number) {

        for(int i = 0; i < number; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto = new Lotto(numbers);

        }

    }

}
