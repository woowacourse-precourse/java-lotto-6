package lotto;

public interface Askable {
    String inputPurchaseAmount = "구입금액을 입력해주세요.";
    String nonPositiveIntegerError = "[ERROR] 구입금액은 양의 정수여야 합니다.";

    <T> T ask();
}