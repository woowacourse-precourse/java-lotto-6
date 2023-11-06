package lotto.validate;

import java.util.List;
import java.util.Objects;

public class InputValidation {
    public static final int  THOUSAND = 1000;
    private final int  ZERO = 0;
    private final String NUMBER_REG_EXP = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    private final String COMMA_REG_EXP = "^,+$";
    private final String ONLY_1_45_NUMBER = "[ERROR] 1-45 사이의 숫자만 입력하세요.";
    private final String ONLY_DIVIDED_THOUSAND = "[ERROR] 금액은 1000단위로 입력하세요.";

    /* =================구입금액 validation=====================*/
    public void validatePhurchaseAmount(String number) {
        isNumber(number);
        isDividedOneThousand(Integer.parseInt(number));
        isNullOrBlank(number);
        numberWhiteSpace(number); // boolean
    }

    // 0-45 숫자 이외의 값이 있는지
    public void isNumber(String number) {
        if (!number.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(ONLY_1_45_NUMBER);
        }
    }
    // 1000으로 나누떨어지는지 > int로 받아야 하는지 String으로 받아야 하는지
    public void isDividedOneThousand(int number) {
        if (number % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ONLY_DIVIDED_THOUSAND);
        }
    }
    // 숫자 사이의 공백, null
    public void isNullOrBlank(String number) {
        if (Objects.isNull(number) || number.isBlank() || numberWhiteSpace(number)) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
        }
    }

    // 숫자 + 스페이스
    public boolean numberWhiteSpace(String number) {
        return !number.replaceAll("\\s","").equals(number);
    }

    /* 당첨 번호 validation*/
    // 1-45 숫자 외 값, 공백은 공통으로 사용

    // , 이외의 값
    public boolean commaOnly(String numbers) {
        return numbers.matches(COMMA_REG_EXP);
    }
    // 6자리 인지
    public boolean isNumbersLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }
    // 중복된 숫자 검사
    public void isDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 입력할 수 없습니다.");
        }
    }

    /* 보너스 번호 validation
    *  당첨번호와 공통으로 사용 */

    // 당첨번호와의 중복 여부
//    public void isDuplicateWinningNumber(String number) {
//        if (lotto.contains(number)) {
//            throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
//        }
//    }
}
