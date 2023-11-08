package lotto.view;

public class ExceptionView {
    public static final String error = "[ERROR] ";

    public static void inputMoneyErrorMessage() {
        System.out.println(error + "로또는 1000원부터 1000원 단위로 구매 가능합니다.");
    }

    public static void inputLottoNumberErrorMessage() {
        System.out.println(error + "로또 번호는 1부터 45 사이 중복되지 않는 6개의 숫자여야 합니다.");
    }

    public static void inputBonusNumberErrorMessage() {
        System.out.println(error + "보너스 번호는 1부터 45 사이 로또 번호와 중복되지 않는 1개의 숫자여야 합니다.");
    }
}
