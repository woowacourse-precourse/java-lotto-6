package lotto.view;

public class Exception_Message {

    private static final int lotto_purchase_unit = 1000;

    private static final String exception_check_input_equals_integer_MESSAGE = "[ERROR] 정수인 숫자만 입력해주십시오.";
    private static final String exception_check_input_equals_positive_number_MESSAGE = "[ERROR] 0보다 큰 숫자만 입력해야합니다.";
    private static final String exception_check_input_equals_satisfy_unit_MESSAGE = "[ERROR] " + lotto_purchase_unit + "원으로 나누어 떨어지는 금액만 입력해야합니다.";


    public static void exception_check_input_equals_integer() {
        System.out.println(exception_check_input_equals_integer_MESSAGE); // 정수 입력이 아닐 때
    }

    public static void exception_check_input_equals_positive_number() {
        System.out.println(exception_check_input_equals_positive_number_MESSAGE); // 정수 입력이 아닐 때
    }

    public static void exception_check_input_equals_satisfy_unit() {
        System.out.println(exception_check_input_equals_satisfy_unit_MESSAGE); // 정수 입력이 아닐 때
    }

}
