package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PLAYER_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    public static void printPlayerLotto(List<Lotto> playerLotto){
        Integer playerLottoCount = playerLotto.size();
        System.out.println(playerLottoCount + PLAYER_LOTTO_COUNT_MESSAGE);
        for(Lotto lotto : playerLotto){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResult(){}
}
