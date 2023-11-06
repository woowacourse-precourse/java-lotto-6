package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        final List<Integer> num = numbergenerator.createRandomNumbers();
        System.out.println(num);
    }
}
