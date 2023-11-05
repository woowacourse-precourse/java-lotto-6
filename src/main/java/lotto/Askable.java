package lotto;

public interface Askable {
    String inputPurchaseAmount = "구입금액을 입력해주세요.";
    String nonPositiveIntegerError = "[ERROR] 구입금액은 양의 정수여야 합니다.";
    String nonThousandUnitError = "[ERROR] 구입금액은 1000원 단위여야 합니다.";

    <T> T ask();
}