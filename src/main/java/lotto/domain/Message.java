package lotto.domain;

public class Message {

    public static final String inputPurchaseAmount = "구입금액을 입력해 주세요.";
    public static final String purchaseConfirmation = "개를 구매했습니다.";
    public static final String inputWinningNumbers = "당첨 번호를 입력해 주세요.";
    public static final String inputBonusNumber = "보너스 번호를 입력해 주세요.";
    public static final String winningStatistics = "당첨 통계\n---";

    public static final String nonNumericInputError = "[ERROR] 숫자를 입력해주세요.";
    public static final String nonDivisibleUnitError = "[ERROR] 1,000원 단위로 입력해주세요.";
    public static final String moreAmountRequiredError = "[ERROR] 1,000원 이상을 입력해주세요.";
    public static final String incorrectCountError = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final String outOfRangeError = "[ERROR] 1~45 범위의 숫자만 입력해주세요.";
    public static final String duplicateNumberError = "[ERROR] 중복되지 않는 숫자를 입력해주세요.";
}
