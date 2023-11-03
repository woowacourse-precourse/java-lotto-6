package lotto;

import camp.nextstep.edu.missionutils.Console;

import static org.assertj.core.api.Assertions.assertThat;

public class Price {

    public static int inputPrice(int price) {
        while (true) {
            while (true) {
                try {
                    price = Integer.parseInt(Console.readLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자로 입력해 주세요.");
                }
            }
            if (price % 1000 == 0) return price;
            System.out.println("[ERROR] 1000단위로 입력해 주세요.");
        }
    }
}
