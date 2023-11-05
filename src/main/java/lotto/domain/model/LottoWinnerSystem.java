package lotto.domain.model;

import lotto.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinnerSystem {

    private final int WINNER_NUMBER_COUNT = 6;
    private final int BONUS_NUMBER_COUNT = 1;

    private List<Integer> winNumbers;
    private List<Integer> bonusNumber;


    // 보너스 번호만 검사 (5개 일치할 때만 실행)
    public boolean isContainBonusNumber(List<Integer> lottoNumber, List<Integer> bonusNumber) {
        if (lottoNumber.contains(bonusNumber.get(0))) {
            return true;
        }
        return false;
    }

    // 보너스 번호를 제외하여 비교
    public int getMatchNumberCount(List<Integer> lottoNumber, List<Integer> winNumber) {
        int matchCount = 0;
        for (int i = 0; i < winNumber.size(); i++) {
            if (lottoNumber.contains(winNumber.get(i))) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    public List<Integer> isValidWinNumber(String input) {
        try {
            List<Integer> numbers = convertIntegerList(input);
            isValidLength(numbers, WINNER_NUMBER_COUNT);
            isDistinct(numbers);
            isValidRange(numbers);

            this.winNumbers = numbers;
            return numbers;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public List<Integer> isValidBonusNumber(String input, List<Integer> winNumbers) {
        try {
            List<Integer> numbers = convertIntegerList(input);
            isValidLength(numbers, BONUS_NUMBER_COUNT);
            isValidRange(numbers);
            isContainWinNumbers(winNumbers, numbers);

            this.bonusNumber = numbers;
            return numbers;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> convertIntegerList(String input) {
        List<Integer> numbers = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }

    private static void isValidLength(List<Integer> numbers, int numberCount) {
        if (numbers.size() != numberCount) {
            throw new IllegalArgumentException("[ERROR] 알맞은 개수의 숫자를 입력해 주세요.");
        }
    }

    private static void isDistinct(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
        }
    }

    private static void isValidRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 && numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 1-45 이내의 숫자를 입력해 주세요.");
            }
        }
    }

    private void isContainWinNumbers(List<Integer> winNumbers, List<Integer> numbers) {
        if (winNumbers.contains(numbers.get(0))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 번호입니다.");
        }
    }
}
