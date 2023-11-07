package lotto.util;

public class Phrase {
    public enum InputPhrase {
        INPUT_COST("구입금액을 입력해 주세요."),
        INPUT_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS("보너스 번호를 입력해 주세요.");
        private final String message;

        InputPhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }
    }

    public enum OutputPhrase {
        BUY_HOWMUCH("%d개를 구매했습니다.\n");
        private final String message;

        OutputPhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }
    }


}
