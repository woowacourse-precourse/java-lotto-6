package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int cost = Integer.parseInt(Console.readLine());
                Play play = new Play(cost);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }
}
