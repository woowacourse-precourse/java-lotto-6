package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final Player player = new Player();

    public static void play() {
        inputLottoPurchaseAmount();
    }

    private static void inputLottoPurchaseAmount() {
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setPurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구매 금액은 1,000원 단위의 숫자여야 합니다.");
            }
        }
    }
}
