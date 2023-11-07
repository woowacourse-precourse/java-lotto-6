package lotto.exception;

public class Exceptions {
    public static IllegalArgumentException exceptionInputPurchaseAmountNotInRange() {
        return new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력하세요.");
    }

    public static IllegalArgumentException exceptionInputPurchaseAmountContainCharacter() {
        return new IllegalArgumentException("[ERROR] 구매 금액은 문자를 포함할 수 없습니다.");
    }

    public static IllegalArgumentException exceptionLottoSize() {
        return new IllegalArgumentException("[ERROR] 로또의 번호가 6개가 아닙니다.");
    }

    public static IllegalArgumentException exceptionLottoDuplication() {
        return new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 존재합니다.");
    }

    public static IllegalArgumentException exceptionWinningNumberNotInRange() {
        return new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력하세요.");
    }

    public static IllegalArgumentException exceptionWinningNumberDuplication() {
        return new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력하세요.");
    }

    public static IllegalArgumentException exceptionWinningNumberSize() {
        return new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
    }

    public static IllegalArgumentException exceptionBonusNumberNotInRange() {
        return new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력하세요.");
    }

    public static IllegalArgumentException exceptionBonusNumberDuplication() {
        return new IllegalArgumentException("[ERROR] 당첨 번호와 다른 숫자를 입력하세요.");
    }


}
