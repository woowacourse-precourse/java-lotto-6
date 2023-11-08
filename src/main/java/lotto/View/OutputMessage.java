package lotto.View;

public enum OutputMessage {

    Enter_Purchase_Mount("구입금액을 입력해 주세요."),
    Enter_Lotto_Numbers("당첨 번호를 입력해 주세요."),
    Enter_Bonus_Numbers("보너스 번호를 입력해 주세요.");

        final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
}
