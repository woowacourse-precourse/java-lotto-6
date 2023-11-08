package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.Validation;
import lotto.validation.ValidationCondition;
import lotto.validation.lotto.domain.LottoDuplicateCondition;
import lotto.validation.lotto.domain.LottoRangeCondition;
import lotto.validation.lotto.input.LottoStringCondition;

public class Lotto {
    private final List<Integer> numbers;
    private static final Validation stringInputValidation;
    private static final Validation lottoDomainValidation;

    public Lotto(List<Integer> numbers) {
        this(convertListToString(numbers));
    }

    public Lotto(String numberString) {
        stringInputValidation.validate(numberString);
        ArrayList<Integer> lotto = new ArrayList<>(convertStringToList(numberString));
        lottoDomainValidation.validate(lotto);
        Collections.sort(lotto);
        this.numbers = lotto;
    }

    static {
        stringInputValidation = new Validation(
                new LottoStringCondition()
        );
        lottoDomainValidation = new Validation(
                new LottoRangeCondition(1, 45),
                new LottoDuplicateCondition( 6)
        );
    }

    private static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static String convertListToString(List<Integer> input) {
        return input.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}
