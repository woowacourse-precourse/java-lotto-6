package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.request.PurchaseAmountDto;
import lotto.controller.dto.response.PurchaseHistoryDto;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;

    public LottoGameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        // 구입 금액 입력
        PurchaseAmountDto purchaseAmount = PurchaseAmountDto.from(Console.readLine());
        // 로또 번호 생성
        LottoStore lottoStore = LottoStore.of(purchaseAmount.getPurchaseAmount());
        // 로또 생성
        Lottos lottos = lottoStore.buyLotto();
        // 로또 번호 반환 및 출력
        PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(lottos.getCount(), lottos.getHistory());
        outputView.printPurchaseHistory(dto);
    }
}
