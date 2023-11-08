package constant;

public final class ErrorMessage {

    public static final String error = "[ERROR] ";
    public static final String onlyNumberMessage = error + "숫자만 입력해주세요.";
    public static final String sameNumberExistMessage = error + "중복된 숫자가 있습니다.";
    public static final String enterOnlySixNumbersMessage = error + "6개의 숫자만 입력해주세요.";
    public static final String enterOneToFourtyFiveMessage = error + "1부터 45까지의 숫자를 입력해주세요";
    public static final String enterOnlyNumberAndComma = error + "숫자와 콤마만 입력 가능합니다.";
    public static final String existInWinningNumbers = error + "당첨번호에 이미 있는 번호입니다.";

    public static final String enterOnlyMultipleOfThounsandMessage =
            error + "로또는 1000원 단위로 구매할 수 있습니다. 1000의 배수를 입력해주세요";
}
