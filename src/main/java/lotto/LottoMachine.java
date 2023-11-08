package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final Integer PRICE = LottoConfig.PRICE.getLottoConfig();
    private final Integer count;
    private List<List<Integer>> lottos;

    public LottoMachine(Integer paymentAmount) {
        validate(paymentAmount);
        this.count = calculateCount(paymentAmount);
    }

    private void validate(Integer paymentAmount) {
        if ((paymentAmount % PRICE) != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_AMOUNT_INVALID.getErrorMessage());
        }
    }

    private static Integer calculateCount(Integer paymentAmount) {
        return paymentAmount / PRICE;
    }

    public void issue() {
        List<List<Integer>> lottos = new ArrayList<>(this.count);
        
        for (int i = 0; i < this.count; i++) {
            List<Integer> lotto = this.issueOne();
            lottos.add(lotto);
        }

        this.lottos = lottos;
    }

    private List<Integer> issueOne() {
        List<Integer> numbers = this.pickRandomNumbers();
        return new Lotto(numbers).getNumbers();
    }

    private List<Integer> pickRandomNumbers() {
        Integer LOTTO_NUMBER_MIN = LottoConfig.LOTTO_NUMBER_MIN.getLottoConfig();
        Integer LOTTO_NUMBER_MAX = LottoConfig.LOTTO_NUMBER_MAX.getLottoConfig();
        Integer LOTTO_LENGTH = LottoConfig.LOTTO_LENGTH.getLottoConfig();

        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_LENGTH);
    }

    public Integer getCount() {
        return count;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
