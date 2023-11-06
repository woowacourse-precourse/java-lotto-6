package lotto.util.message;

public interface MessageFormatter {
	
	String getMessage();
    String getFormattedMessage(Object... params);
}
