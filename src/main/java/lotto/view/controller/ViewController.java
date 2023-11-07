package lotto.view.controller;

import lotto.lotto.dto.LottoDto;
import lotto.view.service.ViewInputService;
import lotto.view.service.ViewOutputService;

import java.util.List;

public class ViewController {

    private final ViewInputService viewInputService;
    private final ViewOutputService viewOutputService;

    public ViewController(ViewInputService viewInputService, ViewOutputService viewOutputService) {
        this.viewInputService = viewInputService;
        this.viewOutputService = viewOutputService;
    }

    public int inputPurchaseAmount() {
        // 당첨 금액 입력 요구 메세지
        viewInputService.printMessagePurchaseAmount();
        // 당첨 금액 입력
        return viewInputService.inputPurchaseAmount();
    }

}
