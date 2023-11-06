package lotto;

public enum Message {
    ERROR_MESSAGE("[ERROR]");

    final String filed;
    Message(String filed){
        this.filed = filed;
    }
}
