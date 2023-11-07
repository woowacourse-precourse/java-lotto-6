package lotto.util;

public class Parser {
    public int lottoPrice (String input) {
        String cleanedInput = input.replaceAll("[, ]", "");
        int number = Integer.parseInt(cleanedInput);
        return number;
    }
}
