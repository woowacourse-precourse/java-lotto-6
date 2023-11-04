package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Validator.LottoNumberValidator;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

/*- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
        - `numbers`의 접근 제어자인 private을 변경할 수 없다.
        - `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
 */

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


}