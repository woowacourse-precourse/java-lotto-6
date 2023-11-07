package lotto.input;

enum RequestPrompt {
    PURCHASE_REQUEST("구입금액을 입력해 주세요."),
    TARGET_REQUEST("정답인 6개의 로또번호를 입력해주세요."),
    BONUS_REQUEST("6개의 번호와 중복되지 않는 보너스번호를 입력해주세요.");
    String message;
    RequestPrompt(String message) {
        this.message = message;
    }
}
