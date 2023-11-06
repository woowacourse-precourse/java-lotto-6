package lotto.view;

enum InputExceptionMessages {

    NOT_A_NUMBER(
            "숫자를 입력해주세요."
    );

    private final String message;

    InputExceptionMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
