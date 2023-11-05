package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.*;
import static lotto.util.CharacterUnits.*;

public class Lotto {
    private final List<Integer> numbers;
    private StringBuilder lottoBuilder;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateEachNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
        this.lottoBuilder = new StringBuilder();
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 구성되야합니다");
        }
    }

    private void validateEachNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number ->
                                !(RANGE_START_NUMBER.getSetting() <= number && number <= RANGE_END_NUMBER.getSetting())
                )
        ) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 허용 범위는 1~45까지입니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                   .collect(Collectors.toSet())
                   .size() != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자로 이루어진 로또를 생성할 수 없습니다.");
        }
    }


    public Prize compareWithWinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        Integer countOfMatchedNumber = compareWithWinnerNumbers(winnerNumbers);
        Boolean isBonusNumber = compareWithBonusNumber(bonusNumber);
        return Prize.of(countOfMatchedNumber, isBonusNumber);
    }


    private Integer compareWithWinnerNumbers(List<Integer> winnerNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(number -> winnerNumbers.contains(number)
                )
                .count());
    }

    private Boolean compareWithBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Lotto lotto = (Lotto) that;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        initLottoBuilder();
        lottoBuilder.append(LEFT_BRACKET.getUnit());
        for (Integer number : numbers) {
            lottoBuilder.append(number);
            lottoBuilder.append(COMMA.getUnit());
            lottoBuilder.append(SPACE.getUnit());
        }

        lottoBuilder.replace(lottoBuilder.length()-TWO.getSetting(),
                                   lottoBuilder.length(),
                                   RIGHT_BRACKET.getUnit()
        );

        return lottoBuilder.toString();
    }

    private void initLottoBuilder() {

        lottoBuilder.setLength(ZERO.getSetting());
    }
}
