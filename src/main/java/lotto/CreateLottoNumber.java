package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoNumber {

    private long ticket_count;
    public PriceValidation priceValidation;
    private List<Integer> numbers;
    public List<Lotto> lotto;
    public List<Double> count;

    public CreateLottoNumber(long total_lotto_price) {
        numbers = new ArrayList<>();
        lotto = new ArrayList<>();
        count = new ArrayList<>();
        priceValidation = new PriceValidation(total_lotto_price);
        ticket_count = priceValidation.createCount();
        createRandomNumber(ticket_count);
    }

    public void createRandomNumber(long count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for(int i = 0; i < count; i++) {
            try {
                numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                for (Integer number : numbers) {
                    if(number > 45 || number < 1) {
                        throw new IllegalArgumentException();
                    }
                }
                lotto.add(new Lotto(numbers));
            } catch(Exception e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void compare(List<Integer> winning_num, Integer bonus_num) {
        for (Lotto lotto1 : lotto) {
            count.add(lotto1.compare(winning_num, bonus_num));
        }
    }

}
