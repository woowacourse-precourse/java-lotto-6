package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        int money = input.getMoney();
        List<Integer> winningNumbers = input.getWinningNumber();
    }
}
