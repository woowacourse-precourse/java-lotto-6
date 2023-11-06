package lotto.constant;

public enum TestMessage {
    MESSAGE("TEST 성공");
    final String message;
    TestMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
