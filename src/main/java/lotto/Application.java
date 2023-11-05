package lotto;

import lotto.generator.NumberGenerator;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = new ArrayList<>();
        numbers = generator.numberGenerator();
        System.out.println(numbers);
    }
}
