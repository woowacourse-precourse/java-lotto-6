package lotto.constants;

public enum ErrorMessages {
    IS_NUMBER_ONLY(" 입력값은 숫자여야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_VALID_CHARACTER(" 구분자는 쉼표(,)여야야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_NUMBER_DUPLICATE(" 번호가 중복되었습니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_NUMBER_OUT_OF_RANGE(" 번호는 1부터 45 사이의 숫자여야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_UNDER_1000(" 로또의 최소 구입 금액은 1,000원이상이어야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_INDIVISIBLE_BY_1000(" 로또 구입 금액은 1,000으로 나누어 떨어지는 숫자이어야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    },
    IS_EMPTY(" 입력값이 있어야 합니다.") {
        @Override
        public String writeErrorMessageByCase() {
            return DEFAULT_ERROR_MESSAGE + getErrorMessage();
        }
    };

    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR]";

    protected final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract String writeErrorMessageByCase();

    public String getErrorMessage() {
        return errorMessage;
    }
}
