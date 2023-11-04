package lotto.view;

public class InputInfo {
    private Exception exception;
    private String userInput;

    public InputInfo(Exception exception, String userInput) {
        this.exception = exception;
        this.userInput = userInput;
    }

    public boolean isValidate() {
        return (exception == null);
    }

    public String getUserInput(){
        return userInput;
    }
}
