package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static class InputPrice {
        final int money = 1000;
        int count;
        int total_price;

        public void game_num() {
            System.out.println("구입금액을 입력해 주세요.");
            String price = Console.readLine();
            total_price = Integer.parseInt(price);
            count = total_price / money;
            System.out.printf("%d개를 구매했습니다.", this.count);
        }
    }

    public class
}


