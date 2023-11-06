package lotto.domain.io;

public enum InputViewFormat {
    GUIDE_CASH("구입금액을 입력해 주세요."),
    GUIDE_LOTTO_ANSWER("당첨번호를 입력해 주세요."),
    GUIDE_BONUS_ANSWER("보너스 번호를 입력해 주세요."),
    GUIDE_STATICS("당첨 통계");

    String state;

    InputViewFormat(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
