package lotto;

public class Judgment{

    public static int divisibleByThousand(int amount){
        int value = amount % 1000;

        if(value != 0){
            throw new IllegalArgumentException();
        }

        return value;
    }
}
