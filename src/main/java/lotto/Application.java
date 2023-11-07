package lotto;

import java.util.List;

public class Application {
    private static ViewInput viewInput = new ViewInput();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = viewInput.getPurchaseAmount();
        List<Integer> numbers = viewInput.getWinningNumbers();

        System.out.println(result);

        for(Integer number : numbers)
            System.out.println(number);
    }
}
