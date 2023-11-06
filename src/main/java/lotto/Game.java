package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void run() {
        saveBuyingPrice();
    }

    private void saveBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String buyingPrice = Console.readLine();
    }
}
