package lotto.util;

public class ParseString {

    public String[] split(String input) {
        String[] splitedInput = input.trim().split("\\s*,\\s*");
        return splitedInput;
    }
}
