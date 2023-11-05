package lotto.domain;

import java.util.regex.Pattern;

// 사용자로부터 입력 받은 로또 구입 금액을 관리하기 위한 클래스
public class Cost {
    private final String REGEXP_NUMBER_PATTERN = "\\d{1,}"; // 숫자만 입력 가능하다.
    private final String REGEXP_COST_PATTERN = "^.*0{3,}$"; // 1000 단위의 수만 입력 가능하다.
    private int cost; // 사용자로부터 입력 받은 로또 구매 금액

    public Cost(String cost) {
        checkValidation(cost);
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return this.cost;
    }

    // 값의 유효성 검사
    private void checkValidation(String cost) {
        checkNumberValidation(cost);
        checkCostValidation(cost);
    }

    // 사용자로부터 입력 받은 값이 숫자가 아닐 경우, 오류를 반환한다.
    private void checkNumberValidation(String cost) {
        if(!Pattern.matches(REGEXP_NUMBER_PATTERN, cost)) {
            throw new IllegalArgumentException();
        }
    }

    // 사용자로부터 입력 받은 값이 1000 단위가 아닐 경우, 오류를 반환한다.
    private void checkCostValidation(String cost) {
        if(!Pattern.matches(REGEXP_COST_PATTERN, cost)) {
            throw new IllegalArgumentException();
        }
    }
}