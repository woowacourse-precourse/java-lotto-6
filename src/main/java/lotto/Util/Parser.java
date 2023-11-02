package lotto.Util;

public class Parser {

    public static final int THOUSAND = 1000;

    public static int convertStringToThousandsMultiple(String input) {
        return Integer.parseInt(input) / THOUSAND;
    }

}
