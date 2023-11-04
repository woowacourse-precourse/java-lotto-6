package lotto.view;

enum ViewConstraints {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTOS("개를 구매했습니다.");

    final private String message;

    ViewConstraints(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getPurchasedLottosMessage(int count) {
        return count + PURCHASED_LOTTOS.message;
    }
}
