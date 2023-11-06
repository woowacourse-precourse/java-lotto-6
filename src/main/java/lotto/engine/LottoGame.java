package lotto.engine;

import java.util.List;
import lotto.engine.dto.WinningNumber;
import lotto.view.LottoGameViewer;

public final class LottoGame {
    private final LottoGameViewer viewer;

    public LottoGame(LottoGameViewer viewer) {
        this.viewer = viewer;
    }

    public void start() {
        int money = viewer.interactForBuyLotto();
        // todo: money 만큼 로또 번호 가져오기 and 출력하기
        List<Integer> numbers = viewer.interactForWinningNumber();
        int bonus = viewer.interactForBonusNumber();

        WinningNumber winningNumber = new WinningNumber(numbers, bonus);
    }
}
