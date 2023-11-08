package lotto;

public class Message {
    public enum Error{
        INVALID_MONEY_INPUT("[ERROR] 구매 금액을 1000원 단위로 작성해주세요."),
        INVALID_WIN_NUMBER("[ERROR] 당첨 번호 6개를 작성해주세요."),
        OVERLAP_INPUT("[ERROR] 입력받은 값에 중복된 값이 포함되어 있습니다."),
        INVALID_INPUT_MIN("[ERROR] 1보다 작은 값을 입력받았습니다."),
        INVALID_INPUT_MAX("[ERROR] 1보다 큰 값을 입력받았습니다."),
        INVALID_INPUT("[ERROR] 입력받은 값이 잘못되었습니다.");

        private final String message;

        Error(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }
}
