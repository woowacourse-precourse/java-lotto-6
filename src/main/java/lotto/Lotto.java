package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoUtil;
import lotto.validator.LottoValidator;

public class Lotto {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        LottoUtil.sortByAsc(numbersCopy);
        this.numbers = numbersCopy;
    }

    public static Lotto generateUserLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(Lotto that) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.retainAll(that.numbers);
        return copyNumbers.size();
    }

    public String getDisplayFormat() {
        return LottoUtil.convertToDisplayFormat(numbers);
    }

}
