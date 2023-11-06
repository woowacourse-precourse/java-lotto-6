package lotto.view;

import lotto.config.Config;

public class ErrorView {

    public static int isNumberError() {
        throw new IllegalArgumentException(Config.ERROR_MESSAGE + " 숫자가 아닙니다.");
    }

    public static int isDivideError() {
        throw new IllegalArgumentException(Config.ERROR_MESSAGE + " 나누어 떨어지지 않는다.");
    }

    public static int isSizeError() {
        throw new IllegalArgumentException(Config.ERROR_MESSAGE + " 크기가 틀리다.");
    }

    public static int isDuplicatedError() {
        throw new IllegalArgumentException(Config.ERROR_MESSAGE + " 중복된 값이 있다.");
    }

    public static int isSmallAndBigError() {
        throw new IllegalArgumentException(Config.ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
