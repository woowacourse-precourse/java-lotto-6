package lotto.view;

import lotto.domain.Player;

public class OutputView {
    public static void showPlayerLotto(Player player, int lottoCount) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoCount);
        player.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
