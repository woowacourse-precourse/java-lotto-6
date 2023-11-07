package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.NumberGenerator;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertLottoNumbers(numbers);
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> new LottoNumber(n.toString()))
                .collect(Collectors.toList());
    }

    public static Lotto createLotto(NumberGenerator generator) {
        return new Lotto(generator.generate(6));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkBonusballContain(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int matchNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lottoNumber -> lotto.contains(lottoNumber))
                .count();
    }
    public boolean contains(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    // TODO: 추가 기능 구현
}
