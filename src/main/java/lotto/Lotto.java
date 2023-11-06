package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeOfLotto(numbers);
        numbers.stream().forEach(number -> checkRangeOfLottoNumber(number));
    }

    private void checkSizeOfLotto(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_SIZE_OF_LOTTO);
        }
    }

    public static void checkRangeOfLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR);
        }
    }

    public static Lotto createRandomNumbersForLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private List<Integer> getNumbers(Lotto numbers) {
        return this.numbers;
    }

    public List<Integer> sortNumbers(Lotto numbers) {
        return getNumbers(numbers).stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getLottoIncludeBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> lottoIncludeBonusNumber = getNumbers(lotto);
        lottoIncludeBonusNumber.add(bonusNumber);
        return lottoIncludeBonusNumber;
    }

    public boolean IsBonusNumberIncluded(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers(lotto).contains(bonusNumber);
    }

    public int getDuplicationNumbers(Lotto lotto, Lotto resultOfLottoIssuance) {
        List<Integer> realLotto = new ArrayList<>(lotto.getNumbers(lotto));
        List<Integer> boughtLotto = new ArrayList<>(resultOfLottoIssuance.getNumbers(resultOfLottoIssuance));
        boughtLotto.retainAll(realLotto);
        if (boughtLotto.isEmpty()) {
            return 0;
        }
        return boughtLotto.size();
    }
}
