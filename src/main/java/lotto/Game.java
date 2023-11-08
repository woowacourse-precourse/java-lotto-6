package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.\n";
    private static final int PRICE_PER_QUANTITY = 1000;
    public Game() {
    }

    public void play() {
        Integer price = getPriceInput();
        getPurchaseQuantity(price);
    }

    public Integer getPriceInput() {
        printMessage(PRICE_INPUT_MESSAGE);
        Integer price = Integer.parseInt(readLine());
        printMessage("");
        return price;
    }

    public Integer getPurchaseQuantity(Integer price){
        Integer quantity = price / PRICE_PER_QUANTITY;
        printMessage(quantity + PURCHASE_QUANTITY_MESSAGE);
        return quantity;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
