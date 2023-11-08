package lotto.validate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class InputValidation {
    public static final int  THOUSAND = 1000;
    private final int  ZERO = 0;
    private final String NUMBER_REG_EXP = "^(?:45|[1-4]?[0-9])(?:,(?:45|[1-4]?[0-9]))*$";
    private final String ONLY_1_45_NUMBER = "[ERROR] 1-45 사이의 숫자만 입력하세요.";
    private final String ONLY_DIVIDED_THOUSAND = "[ERROR] 금액은 1000단위로 입력하세요.";

    /* =================보너스 금액 validation=====================*/
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

    // 6자리 숫자가 ,로 구분되어 있는지
    public void isNumbersDivied6NumbersWithComma(String numbers) {
        if (numbers.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] ,로 구분된 6자리 숫자를 입력해 주세요.");
        }
    }
    // 중복된 숫자 검사
    public void isDuplicate(List<Integer> numbers) {
        if (duplicateCount(numbers) < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 입력할 수 없습니다.");
        }
    }

    public int duplicateCount(List<Integer> numbers) {
        return (int)numbers.stream().distinct().count();
    }

}
