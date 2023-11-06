package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.response.PurchaseHistoryDto;
import lotto.model.LottoStore;
import lotto.model.Money;
import lotto.model.Player;
import lotto.model.RandomNumberGenerator;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;

    public LottoGameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        buyLotto();
    }

    private void buyLotto() {
        try {
            // 구입 금액 입력
            Money money = new Money(Console.readLine());
            Player player = Player.of(money, LottoStore.of(new RandomNumberGenerator()));
            // 로또 구매
            player.buyLotto();
            // 로또 번호 반환 및 출력
            PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(player.getEA(), player.getHistory());
            outputView.printPurchaseHistory(dto);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
    }
}
