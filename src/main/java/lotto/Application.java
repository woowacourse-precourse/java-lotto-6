package lotto;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberCreator generator = new NumberCreator();
        List<Integer> numbers = generator.randomNumbers();
        System.out.println(numbers);
        Input.inputAmount();

    }

}
