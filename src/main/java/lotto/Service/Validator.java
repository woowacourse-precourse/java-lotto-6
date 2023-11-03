package lotto.Service;

public class Validator {
    public static final String SPACE = " ";
    public static final String NULL = "";

    private String removeSpace(String value){
        return value.replaceAll(SPACE, NULL);
    }
}
