package lotto;

public interface Askable<T> {
    String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    String NON_POSITIVE_INTEGER_ERROR = "[ERROR] 구입금액은 양의 정수여야 합니다.";
    String NON_THOUSAND_UNIT_ERROR = "[ERROR] 구입금액은 1000원 단위여야 합니다.";
    String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    String DUPLICATE_NUMBERS_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    String BONUS_NUMBER_SIZE_ERROR = "[ERROR] 보너스 번호는 1개여야 합니다.";

    T ask();
}