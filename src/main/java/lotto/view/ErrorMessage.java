package lotto.view;

public enum ErrorMessage {
    PriceUnderThousand(" 로또는 한 장에 천원입니다. 천 원 이상으로 입력해주세요."),
    priceNotThousandRate(" 로또는 한 장에 천 원입니다. 천 원 단위로 입력해주세요."),
    outOfBound(" 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    duplicateWinning(" 당첨 번호들은 중복되면 안 됩니다."),
    duplicateBonus(" 당첨 번호와 보너스 번호가 중복되면 안 됩니다."),
    toManyComma(" 반점은 숫자마다 하나씩만 넣어주세요."),
    notEnoughLength(" 총 6개의 숫자를 입력하셔야 합니다(구분자는 ',')."),
    notDigit(" 숫자로 입력하셔야 합니다.");

    private final String message;
    private static String commonMessage = "[ERROR]";
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return commonMessage + message;
    }
}
