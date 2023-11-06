package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Integer buyingPrice;

    public void run() {
        saveBuyingPrice();
        giveLotto();
    }

    private void saveBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = Console.readLine();
        buyingPrice = Integer.parseInt(readLine);
    }

    private void giveLotto() {

    }
}
