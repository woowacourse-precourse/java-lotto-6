package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.model.LottoStore;
import lotto.model.vo.Money;
import lotto.model.Player;
import lotto.model.RandomNumberGenerateStrategy;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;
    private ErrorView errorView;

    public LottoGameController(OutputView outputView, ErrorView errorView) {
        this.outputView = outputView;
        this.errorView = errorView;
    }

    public void run() {
        buyLotto();
    }

    private void buyLotto() {
        try {
            // 구입 금액 입력
            outputView.printPurchaseInput();
            Money money = new Money(Console.readLine());
            Player player = Player.of(money);
            // 로또 구매
            player.buyLotto(LottoStore.of(new RandomNumberGenerateStrategy()));
            // 로또 번호 반환 및 출력
            PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(player.getEA(), player.getHistory());
            outputView.printPurchaseHistory(dto);
        } catch(IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            buyLotto();
        }
    }
}
