package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final int lotteryCost = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    static List<Integer> makeLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
        Set<Integer> removeDuplicatedNum = new HashSet<>(numbers);
        if (removeDuplicatedNum.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호엔 중복된 숫자가 있으면 안됩니다.");
    }

    static int lottoAmount(int userMoneyAmount) {
        return userMoneyAmount / lotteryCost;
    }

    // TODO: 추가 기능 구현
}
