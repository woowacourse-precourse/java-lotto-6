package lotto.model.domain.exception;

public class LottoException extends Exception {

    private LottoException() {

    }

    public static void rangeException(int min, int max) {
        throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 "
                + min + "이상 " + max + "이하여야 합니다.");
    }

    public static void duplicateException() {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    public static void countException(int count) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 " + count + "개여야 합니다.");
    }
}
