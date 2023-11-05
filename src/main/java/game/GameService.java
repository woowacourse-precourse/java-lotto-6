package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class GameService {

    public void play() {

        System.out.println("구입금액을 입력해 주세요.");
        int price = getPrice();
    }

    public int getPrice() {
        int price = 0;
        while (price == 0) {
            try {
                String priceInput = Console.readLine();
                if (Integer.parseInt(priceInput) % 1000 == 0) {
                    price = Integer.parseInt(priceInput);
                    return price;
                }
                throw new IllegalArgumentException("Price must be a multiple of 1000");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e);
            }
        }
        return price;
    }
}
