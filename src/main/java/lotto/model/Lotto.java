package lotto.model;

import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.util.NumbersGenerator;

public class Lotto {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createWith(final NumbersGenerator numbersGenerator) {
        List<Integer> numbers = numbersGenerator.generate();
        validateSixNumbers(numbers);
        validateDuplicateNumbers(numbers);
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.createWith(number.toString()))
                .toList();
    }

    private static void validateSixNumbers(final List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers.toString());
        }
    }

    private static boolean hasSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new ExistDuplicatedNumberException(numbers.toString());
        }
    }

    private static boolean hasDuplicate(final List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public boolean isFirstPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == SIX;
    }

    public boolean isSecondPrizeWinner(final List<Integer> winningNumbers, final int bonusNumber) {
        return countMatchingNumbers(winningNumbers) == FIVE && numbers.contains(bonusNumber);
    }

    public boolean isThirdPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == FIVE;
    }

    public boolean isFourthPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == FOUR;
    }

    public boolean isFifthPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == THREE;
    }

    private int countMatchingNumbers(final List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
