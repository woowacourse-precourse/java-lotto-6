package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoNumber {

    private int ticket_count;
    public PriceValidation priceValidation;
    private List<Integer> numbers;
    public List<Lotto> lotto;
    public List<Double> count;

    public CreateLottoNumber(int total_lotto_price) {
        numbers = new ArrayList<>();
        lotto = new ArrayList<>();
        count = new ArrayList<>();
        priceValidation = new PriceValidation(total_lotto_price);
        ticket_count = priceValidation.createCount();
        createRandomNumber(ticket_count);
    }

    public void createRandomNumber(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for(int i = 0; i < count; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        }
    }

    public void compare(List<Integer> winning_num, int bonus_num) {
        for (Lotto lotto1 : lotto) {
            count.add(lotto1.compare(winning_num, bonus_num));
        }

    }

}
