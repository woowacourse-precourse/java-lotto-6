package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Display {
    static int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            int price = Integer.parseInt(input);
            if(price % 1000 > 0) {
                throw new IllegalStateException();
            }
            System.out.println(price / 1000 + "개를 구매했습니다.");
            return price;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
