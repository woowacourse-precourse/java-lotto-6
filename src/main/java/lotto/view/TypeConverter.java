package lotto.view;

public interface TypeConverter {

    default long toLong(String input) {
        return Long.parseLong(input);
    }
}