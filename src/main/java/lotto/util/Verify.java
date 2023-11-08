package lotto.util;

public class Verify {

    public Verify(){}
    public static Integer verifyAmount(String money) throws IllegalArgumentException{
        Integer value = Integer.parseInt(String.valueOf(money));
        if(value < 1000)
            throw new IllegalArgumentException();
        return value;
    }
}
