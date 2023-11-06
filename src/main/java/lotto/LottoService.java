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

    public Lotto generateJackpot(String jackpotNumbers) {
        try {
            return saveJackpotLotto(jackpotNumbers.strip());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다. 숫자를 입력해주세요.");
        }
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

    private Lotto saveJackpotLotto(String jackpotNumbers) {
        List<Integer> numbers = Arrays.stream(jackpotNumbers.split(","))
                .map(this::returnValidatedNumber)
                .toList();
        return new Lotto(numbers, true);
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
}
