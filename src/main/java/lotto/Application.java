package lotto;

import lotto.domain.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Integer amount = input.readAmount();
        System.out.println(amount);
    }
}
