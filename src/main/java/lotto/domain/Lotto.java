package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.utils.NumberGenerator;

public class Lotto {
    private static final String ERROR_SIZE_MESSAGE = "[ERROR] 로또 숫자는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE_MESSAGE = "[ERROR] 로또 숫자가 중복입니다.";

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
            throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
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

    public List<String> getLottoNumberStrings() {
        return numbers.stream()
                .map(number -> number.toString())
                .collect(Collectors.toList());
    }
}
