package lotto.view;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    private static final int LENGTH = 6;
    private static final int LOTTO_PRISE = 1000;

    public static void isNotNumber() {
        System.out.println(ERROR + "숫자를 입력해 주세요.");
    }

    public static void isNotNatural() {
        System.out.println(ERROR + "자연수만 입력 가능합니다.");
    }

    public static void isNotMatchLottoLength() {
        System.out.println(ERROR + "입력하신 로또 번호의 개수가 맞지 않습니다. 다시 입력해 주세요. (" + LENGTH + "개)");
    }

    public static void isNotDivideByLottoAmount() {
        System.out.println(ERROR + "지불할 금액은 로또 가격의 배수여야 합니다. (현재 로또 가격: " + LOTTO_PRISE + ")");
    }

    public static void isNotInRange() {
        System.out.println(ERROR + "입력하신 숫자가 해당 범위내에 있지 않습니다.");
    }

    public static void isDuplicatedLotto() {
        System.out.println(ERROR + "중복되는 숫자가 존재합니다.");
    }

    public static void lottoContainsBonusNumber() {
        System.out.println(ERROR + "보너스 번호가 이미 로또에 존재합니다.");
    }
}
