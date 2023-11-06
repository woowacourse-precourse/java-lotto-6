package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;
import lotto.domain.vo.Bonus;
import lotto.storage.LottoStorage;

public class LottoService {
    private static final BigDecimal PRICE_PER_LOTTO = new BigDecimal(1000);
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final LottoStorage lottoStorage;

    public LottoService(LottoStorage lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public List<Lotto> generateLotteries(BigDecimal payment) {
        int numberOfLotteries = payment.divide(PRICE_PER_LOTTO, RoundingMode.UNNECESSARY)
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
        validateBonusNumberNotDuplicate(jackpotNumbers, bonus.getBonusNumber());
        Lotto jackpotLotto = new Lotto(jackpotNumbers, bonus);
        return lottoStorage.saveLotto(jackpotLotto);
    }

    public LottoResults matchLotteries() {
        Lotto jackpotLotto = lottoStorage.findJackpot()
                .orElseThrow(() -> new IllegalArgumentException("아직 입력된 당첨 번호가 없습니다."));
        List<Lotto> lotteries = lottoStorage.findAllBoughtLotteries();
        List<LottoResult> results = lotteries.stream()
                .map(lotto -> generateLottoResult(jackpotLotto, lotto))
                .toList();
        return LottoResults.of(results);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_COUNT);
        return numbers.stream()
                .sorted()
                .toList();
    }

    private Lotto saveRandomLotto() {
        List<Integer> numbers = generateRandomNumbers();
        Lotto lotto = new Lotto(numbers);
        return lottoStorage.saveLotto(lotto);
    }

    private List<Integer> returnValidatedNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::returnValidatedNumber)
                .toList();
    }

    private Integer returnValidatedNumber(String numberInput) {
        Integer number = Integer.parseInt(numberInput.strip());
        validateNumber(number);
        return number;
    }

    private void validateNumber(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
        }
    }

    private void validateBonusNumberNotDuplicate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private LottoResult generateLottoResult(Lotto jackpotLotto, Lotto lotto) {
        long count = lotto.countMatchingNumbers(jackpotLotto);
        return LottoResult.from(count);
    }
}
