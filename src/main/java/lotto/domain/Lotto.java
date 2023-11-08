package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> createLottoTickets(List<List<Integer>> lottoNumbers) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (List<Integer> numbers : lottoNumbers) {
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(numbers);
        if (numbersWithoutDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public PrizeCategory compareTo(LottoNumbers lottoNumbers) {
        int matchingNumbers = 0;
        List<Integer> winningNumbers = lottoNumbers.getWinningNumbers();
        int bonusNumber = lottoNumbers.getBonusNumber();
        for (int number : winningNumbers) {
            if (this.numbers.contains(number)) {
                matchingNumbers++;
            }
        }

        if (isLose(matchingNumbers)) {
            return PrizeCategory.LOSE;
        }

        return calculatePrizeCategory(matchingNumbers, bonusNumber);
    }

    private boolean isLose(int matchingNumbers) {
        return matchingNumbers <= 2;
    }

    private PrizeCategory calculatePrizeCategory(int matchingNumbers, int bonusNumber) {
        if (matchingNumbers == 3) {
            return PrizeCategory.FIFTH;
        }
        if (matchingNumbers == 4) {
            return PrizeCategory.FOURTH;
        }
        if (matchingNumbers == 5 && !this.numbers.contains(bonusNumber)) {
            return PrizeCategory.THIRD;
        }
        if (matchingNumbers == 5) {
            return PrizeCategory.SECOND;
        }
        return PrizeCategory.FIRST;
    }

    // 테스트를 위한 함수 정의
    List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }
}
