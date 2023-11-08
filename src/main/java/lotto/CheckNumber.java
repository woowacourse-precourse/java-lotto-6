package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumber {
    public static void checkPurchaseMoney(int perchaseInput){ // 구매 금액이 올바른지 확인한다
        if(perchaseInput < 1000){ // 1000원보다 낮으면 예외 발생
            throw new IllegalArgumentException("로또를 구매할 수 없는 금액입니다");
        }
        if(perchaseInput % 1000 != 0){ // 1000으로 나눌 수 없으면 예외 발생
            throw new IllegalArgumentException("1000으로 나누어 떨어지지 않는 수입니다");
        }
    }
    public static void checkTextInput(String stringInput){ // 숫자로만 구성되어 있는지 확인한다
        Pattern pattern = Pattern.compile("^[0-9]+$"); // 정규 표현식: 숫자로만 구성된 문자열
        Matcher matcher = pattern.matcher(stringInput); // 숫자로 구성되어 있는지 확인
        if (!matcher.matches()) { // 숫자로 구성되지 않은 값이 있으면 예외 발생
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
    }
}
