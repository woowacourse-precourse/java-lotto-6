package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String DUPLICATE_ERROR = "[ERROR]중복된 번호는 사용할 수 없습니다.";
    public static final String SIZE_ERROR = "[ERROR]로또 번호는 6개만 가능합니다.";
    public static final String BONUS_ERROR = "[ERROR]보너스 번호는 로또 번호에 포함될 수 없습니다.";
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }
    public Lotto() {
        this(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
    private static Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }
    private void validateDuplicates(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public void checkForBonusNumber(BonusNumber bonusNumber) {
        if (bonusNumber.isContainedIn(this.numbers)) {
            throw new IllegalArgumentException(BONUS_ERROR);
        }
    }

    public int calculateSameCount(Lotto otherLotto) {
        return compareLottoNumbers(otherLotto.number());
    }

    private int compareLottoNumbers(List<Integer> otherNumbers) {
        Set<Integer> commonNumbers = new HashSet<>(this.numbers);
        commonNumbers.retainAll(otherNumbers);
        return commonNumbers.size();
    }
    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isContainedIn(this.numbers);
    }
    public List<Integer> number() {
        return numbers;
    }
}


