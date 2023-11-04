package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Play {

    public void play() {

    }

    public int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        try {
            validate(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchase();
        }


        return 0;
    }

    // 입력받은 금액이 1000원 단위가 아니면 예외 발생
    public void validate (String price) {
        if (Double.parseDouble(price) % 1000 != 0.0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
