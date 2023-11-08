package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameManager;
import lotto.domain.User;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        gameManager.startLottoGame();
        User user = new User();
        boolean iterationTrigger;
        int lottoCount;
        iterationTrigger = true;
        while (iterationTrigger) {
            try {
                lottoCount = user.buyLotto(Console.readLine());
                iterationTrigger = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
