/**
 * @Package_name : model
 * @Class_name : Lotto
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.List;
import model.enums.LottoSystem;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    /**
     * Description : 6개 숫자가 맞는지 확인
     *
     * @Method : validate()
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoSystem.LOTTO_SET_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Description : 1-45 범위 숫자가 맞는지 확인
     *
     * @Method : validateNumberRange()
     */
    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoSystem.LOTTO_MAX_RANGE.getValue() || number < LottoSystem.LOTTO_MIN_RANGE.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Description : LottoNumbers 로또숫자들 반환
     *
     * @Method : getLottoNumbers()
     * @return : List<Integer>
     */
    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
