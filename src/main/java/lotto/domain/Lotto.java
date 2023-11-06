package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateSameItem(numbers);
        this.numbers = numbers;
    }

    public boolean contain(LottoNumber bounus) {
        return numbers.contains(bounus);
    }

    public Integer calcSimilarity(Lotto lotto) {
        return (int) this.numbers.stream().filter(lotto::contain).count();
    }

    public List<LottoNumber> toIntegerList() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateSameItem(List<LottoNumber> numbers) {
        if (hasSameItem(numbers)) {
            throw new IllegalArgumentException("중복된 값을 입력하지 마세요.");
        }
    }

    private static boolean hasSameItem(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (isUnsuitableSize(numbers)) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
    }

    private static boolean isUnsuitableSize(List<LottoNumber> numbers) {
        return !LottoConstraint.checkSize(numbers.size());
    }
}
