package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.model.number.LottoNumber;

public class Validator {
    public static void validatePurchaseAmount(int amount) {
        String regex = "^[1-9]\\d*000$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(amount));
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 0이상의 정수를 입력해주세요.");
        }
    }

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (isLottoNumberDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        numbers.forEach(number -> validateLottoNumber(number.getNumber()));
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    /**
     * Description: Validate LottoNumbers<br> rule1: matchCount must be between 3 and 6<br>
     *
     * @param matchCount
     * @throws IllegalArgumentException
     */
    public static void validateMatchCount(int matchCount) {
        if (matchCount < 3 || matchCount > 6) {
            throw new IllegalArgumentException("[ERROR] 3 미만, 6 초과의 숫자는 Prize가 될 수 없습니다.");
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
