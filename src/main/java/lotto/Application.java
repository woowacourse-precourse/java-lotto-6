package lotto;

import lotto.domain.Player;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                Player player = new Player(InputView.inputPlayerAmount());
                int result = player.calculateLottoCount();
                System.out.println(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] "+ e.getMessage());
            }
        }
    }
}
