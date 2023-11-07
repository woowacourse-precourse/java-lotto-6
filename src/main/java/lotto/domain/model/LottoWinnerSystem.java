package lotto.domain.model;

import lotto.domain.util.ErrorMessage;
import lotto.domain.util.InputValidator;
import lotto.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinnerSystem {

    private final int WINNER_NUMBER_COUNT = 6;
    private final int BONUS_NUMBER_COUNT = 1;

    private final static int FIRST_PRIZE_MONEY = 2000000000;
    private final static int SECOND_PRIZE_MONEY = 30000000;
    private final static int THIRD_PRIZE_MONEY = 1500000;
    private final static int FOURTH_PRIZE_MONEY = 50000;
    private final static int FIFTH_PRIZE_MONEY = 5000;

    private static int first;
    private static int second;
    private static int third;
    private static int fourth;
    private static int fifth;

    public LottoWinnerSystem() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
        this.fourth = 0;
        this.fifth = 0;
    }

    // 당첨 번호가 유효한지 검사
    public List<Integer> isValidWinNumber(String input) {
        try {
            InputValidator.isNull(input);
            InputValidator.isEmptyOrBlank(input);
            List<Integer> numbers = convertIntegerList(input);
            isValidLength(numbers, WINNER_NUMBER_COUNT);
            isDistinct(numbers);
            isValidRange(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_INPUT.getErrorMessage());
        }
    }

    // 보너스 번호가 유효한지 검사
    public List<Integer> isValidBonusNumber(String input, List<Integer> winNumbers) {
        try {
            InputValidator.isNull(input);
            InputValidator.isEmptyOrBlank(input);
            List<Integer> numbers = convertIntegerList(input);
            isValidLength(numbers, BONUS_NUMBER_COUNT);
            isValidRange(numbers);
            isContainWinNumbers(winNumbers, numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_INPUT.getErrorMessage());
        }
    }

    // 발행한 로또를 1개씩 비교
    public void isWinnerLotto(List<Lotto> purchasedLotto, List<Integer> winNumber, List<Integer> bonusNumber) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            List<Integer> compareLotto = purchasedLotto.get(i).getLotto();
            int matchCount = getMatchNumberCount(compareLotto, winNumber);
            if (matchCount >= 3) {
                compareOneLotto(compareLotto, bonusNumber, matchCount);
            }
        }
    }

    // 일치하는 번호 개수에 따라 당첨 통계 업데이트
    public void compareOneLotto(List<Integer> compareLotto, List<Integer> bonusNumber, int matchCount) {
        if (matchCount == 3) {
            fifth += 1;
        }
        if (matchCount == 4) {
            fourth += 1;
        }
        if (matchCount == 5) {
            bonusCase(compareLotto, bonusNumber);
        }
        if (matchCount == 6) {
            first += 1;
        }
    }

    // 5개 일치할 때 보너스 번호에 따라 당첨 통계를 다르게 업데이트
    public void bonusCase(List<Integer> compareLotto, List<Integer> bonusNumber) {
        if (isContainBonusNumber(compareLotto, bonusNumber)) {
            second += 1;
            return;
        }
        third += 1;
    }

    // 당첨 번호와 비교
    public int getMatchNumberCount(List<Integer> lottoNumber, List<Integer> winNumber) {
        int matchCount = 0;
        for (int i = 0; i < winNumber.size(); i++) {
            if (lottoNumber.contains(winNumber.get(i))) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    // 보너스 번호만 검사 (5개 일치할 때만 실행)
    public boolean isContainBonusNumber(List<Integer> lottoNumber, List<Integer> bonusNumber) {
        if (lottoNumber.contains(bonusNumber.get(0))) {
            return true;
        }
        return false;
    }

    // 수익률 계산
    public static int calculateProfitMoney() {
        int profitMoney = (FIFTH_PRIZE_MONEY * fifth) + (FOURTH_PRIZE_MONEY * fourth) +
                (THIRD_PRIZE_MONEY * third) + (SECOND_PRIZE_MONEY * second) + (FIRST_PRIZE_MONEY * first);
        return profitMoney;
    }

    // 당첨 통계 출력
    public void printLottoResult() {
        OutputView.printTotalResult(fifth, fourth, third, second, first);
    }


    public List<Integer> convertIntegerList(String input) {
        List<Integer> numbers = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }

    public static void isValidLength(List<Integer> numbers, int numberCount) {
        if (numbers.size() != numberCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH_INPUT.getErrorMessage());
        }
    }

    public static void isDistinct(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public static void isValidRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER.getErrorMessage());
            }
        }
    }

    public void isContainWinNumbers(List<Integer> winNumbers, List<Integer> numbers) {
        if (winNumbers.contains(numbers.get(0))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getErrorMessage());
        }
    }
}
