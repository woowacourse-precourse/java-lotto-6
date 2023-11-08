package lotto.model;

import static lotto.constant.RuleConstant.DEFAULT_VALUE;
import static lotto.constant.RuleConstant.LOTTO_RANGE;
import static lotto.constant.RuleConstant.MAX_NUMBER;
import static lotto.constant.RuleConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.RuleConstant;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(int money) {
        int count = getLottoCount(money);
        lottos = createLottos(count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> newLottos = new ArrayList<>();

        for (int i = RuleConstant.DEFAULT_VALUE.getValue(); i < count; i++) {
            List<Integer> numbers = makeLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            newLottos.add(lotto);
        }

        return newLottos;
    }

    public int getLottoCount(int money) {
        return money / RuleConstant.LOTTO_PRICE.getValue();
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> numbers = makeRandomNumbers();
        int left = DEFAULT_VALUE.getValue();
        int right = LOTTO_RANGE.getValue() - 1;
        sortNumbers(numbers, left, right);
        return numbers;
    }

    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_RANGE.getValue());
        return numbers;
    }

    public void sortNumbers(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int q = partition(numbers, left, right);
            sortNumbers(numbers, left, q - 1);
            sortNumbers(numbers, q + 1, right);
        }
    }

    public int partition(List<Integer> numbers, int left, int right) {
        int pivot = numbers.get(right);
        int low = left - 1;
        int high = right;

        do {
            do {
                low++;
            } while (numbers.get(low) < pivot);
            do {
                high--;
            } while (numbers.get(high) > pivot && high > 0);

            if (low < high) {
                swap(numbers, low, high);
            }

        } while (low < high);
        swap(numbers, low, right);
        return low;
    }

    public void swap(List<Integer> numbers, int a, int b) {
        if (a != b) {
            Integer e1 = numbers.get(a);
            Integer e2 = numbers.get(b);
            numbers.set(a, e2);
            numbers.set(b, e1);
        }
    }
}
