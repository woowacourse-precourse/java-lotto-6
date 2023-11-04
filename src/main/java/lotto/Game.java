package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    Game() {

    }

    void play() {
        System.out.println("구입금액을 입력해 주세요.");
        double purchaseAmount = Double.parseDouble(readLine());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다");
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1000원 보다 커야합니다.");
        }
    }
}
