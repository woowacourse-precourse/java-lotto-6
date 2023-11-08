package lotto.util.message;

import static lotto.util.Constant.ERROR;

public class ErrorMessage extends Message {

    public static void invalidPurchasePriceUnit() {
        System.out.println(ERROR + "로또 금액은 1,000원 단위여야 합니다.");
    }

    public static void invalidFormat() {
        System.out.println(ERROR + "올바른 숫자를 입력해 주세요.");
    }

    public static void invalidLottoRange() {
        System.out.println(ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void invalidLottoLength() {
        System.out.println(ERROR + "로또는 6개 숫자여야 합니다.");
    }

    public static void duplicatedLottoNumber() {
        System.out.println(ERROR + "중복된 숫자는 입력할 수 없습니다.");
    }
}
