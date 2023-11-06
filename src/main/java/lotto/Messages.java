package lotto;

public class Messages {
    public enum ErrorMessage{
        NONNUMERICCHAR("[ERROR] 숫자가 아닌 문자가 입력되었습니다."),
        NULLSTRING("[ERROR] 비어있는 문자열이 입력되었습니다.");

        private String errorMessage;
        private ErrorMessage(String message){
            this.errorMessage = message;
        }
        public String getMessage(){
            return this.errorMessage;
        }
    }
}
