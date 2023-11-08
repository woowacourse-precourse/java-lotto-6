package lotto.view;

public class Exception_Message {

    private static final int lotto_purchase_unit = 1000;
    private static final int min_number = 1;
    private static final int max_number = 45;

    private static final String exception_check_input_equals_integer_MESSAGE = "[ERROR] 정수인 숫자만 입력해주십시오.";
    private static final String exception_check_input_equals_positive_number_MESSAGE = "[ERROR] 0보다 큰 숫자만 입력해야합니다.";
    private static final String exception_check_input_equals_satisfy_unit_MESSAGE = "[ERROR] " + lotto_purchase_unit + "원으로 나누어 떨어지는 금액만 입력해야합니다.";
    private static final String exception_check_sizes_equals_numbers_size_MESSAGE = "[ERROR] 6개의 숫자를 입력해야합니다.";
    private static final String exception_check_range_equals_certain_ranges_MESSAGE = "[ERROR] " + min_number + "~" + max_number + "사이의 숫자만 입력할 수 있습니다.";
    private static final String exception_check_lotto_numbers_overlap_MESSAGE = "[ERROR] 중복된 숫자는 사용 불가합니다.";
    private static final String exception_check_bonus_number_overlap_MESSAGE = "[ERROR] 보너스 번호는 앞의 6개의 숫자와 중복되지 않은 번호만 가능합니다.";


    public static void exception_check_input_equals_integer() {
        System.out.println(exception_check_input_equals_integer_MESSAGE); // 정수 입력이 아닐 때
    }

    public static void exception_check_input_equals_positive_number() {
        System.out.println(exception_check_input_equals_positive_number_MESSAGE); // 양수가 아닐 때
    }

    public static void exception_check_input_equals_satisfy_unit() {
        System.out.println(exception_check_input_equals_satisfy_unit_MESSAGE); // 최소 단위로 나누어지지 않을 때
    }

    public static void exception_check_sizes_equals_numbers_size() {
        System.out.println(exception_check_sizes_equals_numbers_size_MESSAGE); // 당첨 번호가 6개가 아닐 경우
    }
    public static void exception_check_range_equals_certain_ranges() {
        System.out.println(exception_check_range_equals_certain_ranges_MESSAGE); // 로또 번호 범위가 벗어날 경우
    }

    public static void exception_check_lotto_numbers_overlap() {
        System.out.println(exception_check_lotto_numbers_overlap_MESSAGE); // 중복된 로또 번호 입력
    }

    public static void exception_check_bonus_number_overlap() {
        System.out.println(exception_check_bonus_number_overlap_MESSAGE); // 중복된 로또 번호 입력
    }

}
