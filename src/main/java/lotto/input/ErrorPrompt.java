package lotto.input;

enum ErrorPrompt {
    PURCHASE_ERROR("[ERROR] 지불할 금액을 다시 입력해주세요."),
    TARGET_ERROR("[ERROR] 유효한 로또 정답 입력이 아닙니다."),
    BONUS_ERROR("[ERROR] 유효한 보너스 번호 입력이 아닙니다.");

    String message;
    ErrorPrompt(String message) {
        this.message = message;
    }
}
