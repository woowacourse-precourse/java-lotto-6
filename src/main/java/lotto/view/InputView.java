package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPrice() throws IllegalArgumentException {
        int price = Integer.parseInt(Console.readLine());

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1000원으로 나누어 떨어지지 않는다.");
        }
        return Integer.parseInt(Console.readLine());
    }
}
