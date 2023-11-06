package lotto.controller;

import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.service.LotteryService;
import lotto.service.Service;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final Service service;

    public LottoController(final View view, final Service service) {
        this.view = view;
        this.service = service;
    }

    public static LottoController from(final View view) {
        return new LottoController(view, LotteryService.create());
    }

    public void run() {
        String inputPurchaseAmount = view.askPurchaseAmount();
        LottoPurchaseDto lottoPurchaseDto = service.buyLottery(inputPurchaseAmount);
        view.printPurchaseQuantity(lottoPurchaseDto);
        LottosDto lottosDto = service.generateLotto(lottoPurchaseDto.quantity());
        view.printLottoNumbers(lottosDto);
        String inputWinningNumber = view.askWinningNumber();
        view.close();
    }
}
