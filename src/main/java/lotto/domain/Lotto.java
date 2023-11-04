package lotto.domain;

import java.util.List;
import lotto.constants.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSameLength(numbers)) {
            //TODO : exception을 날리는 메서드로 분리
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d개로 로또를 생성하려 했습니다. 로또의 번호는 6개 입니다", numbers.size()));
        }
        if (!isDupplicated(numbers)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또의 숫자는 중복될 수 없습니다."));
        }
    }

    private boolean isDupplicated(List<Integer> numbers) {
        List<Integer> duplicated = numbers.stream().distinct().toList();
        return duplicated.size() == numbers.size();
    }

    private boolean isSameLength(List<Integer> numbers) {
        return numbers.size() != LottoConstants.LENGTH.getConstants();
    }

    public static Lotto createAutoLottoNumbers(Generator generator) {
        return new Lotto(generator.generate());
    }
}
