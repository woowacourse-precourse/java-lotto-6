package lotto.message;

public class RangeMessageFormatter {

    public static String rangeMessage(
        String preMessage,
        int value,
        int min,
        int max,
        String postMessage
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(preMessage)
            .append(", 입력값: ").append(value)
            .append(", 허용 범위: ")
            .append(min).append(" ~ ").append(max)
            .append(postMessage);

        return sb.toString();
    }
}
