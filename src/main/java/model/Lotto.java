package model;

import static consts.NumericConfig.END_INCLUSIVE;
import static consts.NumericConfig.LOTTO_COUNT;
import static consts.NumericConfig.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import validator.LottoValidator;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .map(LottoNumber::from)
            .toList();
    }

    public static Lotto createDefault() {
        List<Integer> numbers = generateNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.number(), END_INCLUSIVE.number(),
            LOTTO_COUNT.number());
    }

    private static void validate(final List<Integer> numbers) {
        LottoValidator validator = new LottoValidator();
        validator.validateLottoNumbers(numbers);
    }

    public LottoNumber generateUniqueNumber() {
        LottoNumber number = pickNewNumber();

        while (isContainNumber(number)) {
            number = pickNewNumber();
        }
        return number;
    }

    private static LottoNumber pickNewNumber() {
        return LottoNumber.from(
            Randoms.pickNumberInRange(START_INCLUSIVE.number(), END_INCLUSIVE.number()));
    }

    public boolean isContainNumber(final LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public long compareLotto(final Lotto lotto) {
        return lotto.getNumbers()
            .stream()
            .filter(this::isContainNumber)
            .count();
    }
}
