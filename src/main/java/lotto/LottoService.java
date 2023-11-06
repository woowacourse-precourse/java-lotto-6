package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private final LottoStorage lottoStorage;

    public LottoService(LottoStorage lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public List<Lotto> generateLotteries(BigDecimal payment) {
        int numberOfLotteries = payment.divide(new BigDecimal(1000), RoundingMode.UNNECESSARY)
                .intValueExact();
        return IntStream.range(0, numberOfLotteries)
                .mapToObj(index -> saveRandomLotto())
                .toList();
    }

    public List<Integer> generateJackpotNumbers(String jackpotNumbers) {
        try {
            return returnValidatedNumbers(jackpotNumbers.split(","));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다. 숫자를 입력해주세요.");
        }
    }

    public Bonus generateBonus(String bonusNumber) {
        try {
            Integer validatedBonusNumber = returnValidatedNumber(bonusNumber);
            return new Bonus(validatedBonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다. 숫자를 입력해주세요.");
        }
    }

    public Lotto saveJackpotLotto(List<Integer> jackpotNumbers, Bonus bonus) {
        Lotto jackpotLotto = new Lotto(jackpotNumbers, bonus);
        lottoStorage.saveLotto(jackpotLotto);
        return jackpotLotto;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream()
                .sorted()
                .toList();
    }

    private Lotto saveRandomLotto() {
        List<Integer> numbers = generateNumbers();
        Lotto lotto = new Lotto(numbers);
        return lottoStorage.saveLotto(lotto);
    }

    private Integer returnValidatedNumber(String numberInput) {
        Integer number = Integer.parseInt(numberInput.strip());
        validateNumber(number);
        return number;
    }

    private void validateNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
        }
    }

    private List<Integer> returnValidatedNumbers(String[] numbers) {
        List<Integer> validatedNumbers = Arrays.stream(numbers)
                .map(this::returnValidatedNumber)
                .toList();
        validateDistinct(validatedNumbers);
        return validatedNumbers;
    }

    private void validateDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException("중복이 포함되어 있습니다.");
        }
    }
}
