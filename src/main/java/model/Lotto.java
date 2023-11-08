/**
 * @Package_name : model
 * @Class_name : Lotto
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.List;
import java.util.stream.Collectors;
import model.enums.LottoSystem;
import model.lottoException.LottoNumNotSixException;
import model.lottoException.LottoNumSameException;
import model.lottoException.LottoNumberRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws LottoNumNotSixException, LottoNumberRangeException, LottoNumSameException {
        validate(numbers);
        validateNumberRange(numbers);
        validateNumSame(numbers);
        this.numbers = numbers;
    }

    /**
     * Description : 6개 숫자가 맞는지 확인
     *
     * @Method : validate()
     */
    private void validate(List<Integer> numbers) throws LottoNumNotSixException {
        if (numbers.size() != LottoSystem.LOTTO_SET_LENGTH.getValue()) {
            throw new LottoNumNotSixException();
        }
    }

    /**
     * Description : 1-45 범위 숫자가 맞는지 확인
     *
     * @Method : validateNumberRange()
     */
    private void validateNumberRange(List<Integer> numbers) throws LottoNumberRangeException {
        for (int number : numbers) {
            if (number > LottoSystem.LOTTO_MAX_RANGE.getValue() || number < LottoSystem.LOTTO_MIN_RANGE.getValue()) {
                throw new LottoNumberRangeException();
            }
        }
    }

    /**
     * Description : 숫자가 중복되지 않았는지 확인
     *
     * @Method : validateNumSame()
     */
    private void validateNumSame(List<Integer> numbers) throws LottoNumSameException {
        List<Integer> newNumbers = numbers.stream().distinct().toList();
        if (newNumbers.size() != 6) {
            throw new LottoNumSameException();
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
