package lotto.view;

//TODO : 에러 메시지 작성
public class ErrorMessage {
    private final static String error = "[ERROR]";

    public static void outOfBoundExceptionMessage() {
        System.out.println(error + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void notDigitExceptionMessage() {
        System.out.println(error + " 숫자로 입력하셔야 합니다.");
    }

    public static void notEnoughLengthOfWinningNumbersExceptionMessage() {
        System.out.println(error + " 총 6개의 숫자를 입력하셔야 합니다(구분자는 ',').");
    }

    public static void priceZeroException() {
        System.out.println(error + " 로또는 한 장에 천원입니다. 한 장이라도 사주세요.");
    }

    public static void duplicatedBonusNumber() {
        System.out.println(error + " 당첨 번호와 보너스 번호가 중복되면 안 됩니다.");
    }

    public static void duplicatedWinningNumbers() {
        System.out.println(error + " 당첨 번호들은 중복되면 안 됩니다.");
    }
}
