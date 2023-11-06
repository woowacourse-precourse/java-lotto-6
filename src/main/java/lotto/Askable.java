package lotto;

public interface Askable<T> {
    String inputPurchaseAmount = "구입금액을 입력해주세요.";
    String inputWinningNumbers = "당첨 번호를 입력해주세요.";
    String inputBonusNumber = "보너스 번호를 입력해 주세요.";
    String nonPositiveIntegerError = "[ERROR] 구입금액은 양의 정수여야 합니다.";
    String nonThousandUnitError = "[ERROR] 구입금액은 1000원 단위여야 합니다.";
    String numberRangeError = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    String duplicateNumbersError = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    String WinningNumberAmountError = "[ERROR] 로또 번호는 6개여야 합니다.";
    String BonusNumberAmountError = "[ERROR] 보너스 번호는 1개여야 합니다.";

    T ask();
}