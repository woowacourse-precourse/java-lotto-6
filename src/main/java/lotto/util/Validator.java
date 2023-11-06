package lotto.util;

import java.util.List;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class Validator {
    /**
     * Description: Validate LottoNumbers<br> rule1: LottoNumbers must have 6 numbers<br> rule2: LottoNumbers must have
     * unique numbers<br>
     *
     * @param numbers
     * @return void
     * @throws IllegalArgumentException
     */
    public static void validateLottoNumbers(List<LottoNumber> numbers) {
        if (isLotteryNumberSizeValid(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (isLottoNumberDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    /**
     * Description: Validate LottoNumber<br> rule1: LottoNumber must be between 1 and 45<br>
     *
     * @param number
     * @return void
     * @throws IllegalArgumentException
     */
    public static void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    /**
     * Description: Validate LottoNumbers<br> rule1: LottoNumbers must have 6 numbers
     *
     * @param numbers
     * @return boolean
     */
    private static boolean isLotteryNumberSizeValid(List<LottoNumber> numbers) {
        return numbers.size() != 6;
    }

    /**
     * Description: Validate LottoNumbers<br> rule2: LottoNumbers must have unique numbers
     *
     * @param numbers
     * @return boolean
     */
    private static boolean isLottoNumberDuplicate(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
