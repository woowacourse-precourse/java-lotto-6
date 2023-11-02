package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.utils.ValidationUtil;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 로또 번호를 관리하는 Domain, 초기 설정의 힌트는 검증을 생성자에서 이루는게 옳다는 것?
     */
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        ValidationUtil.validateCorrectNumbersCount(numbers);
        ValidationUtil.validateNoDuplicates(numbers);
        ValidationUtil.validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public LottoDto toDTO() {
        return new LottoDto(numbers);
    }
}
