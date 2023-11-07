package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.enums.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        CheckDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void CheckDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    static List<Lotto> createLottos(long numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }

    static int countWinningNumberInLotto(List<Integer> winningNumber, Lotto lotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (checkLottoNumberInWinningNumber(winningNumber, lotto.getNumbers().get(i))) {
                count += 1;
            }
        }
        return count;
    }

    //메서드 분리
    static Rank judgeLottoRank(List<Integer> winningNumber, Lotto lotto, int bonusNumber) {
        int count = countWinningNumberInLotto(winningNumber, lotto);
        if (count >= 0 && count < 3)
            return Rank.NOT;
        if (count == 3)
            return Rank.FIFTH;
        if (count == 4)
            return Rank.FOURTH;
        if (count == 5) {
            if (isBonusNumberInLotto(lotto, bonusNumber))
                return Rank.SECOND;
            return Rank.THIRD;
        }
        return Rank.FIRST;
    }

    static boolean checkLottoNumberInWinningNumber(List<Integer> winningNumber, int numberInLotto) {
        return winningNumber.contains(numberInLotto);
    }

    static boolean isBonusNumberInLotto(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
