package lotto.controller;

import static lotto.constant.Message.WINNING_STATS;

import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.dto.ReturnRateDto;
import lotto.dto.WinningResultDto;
import lotto.service.LottoService;
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
        return new LottoController(view, LottoService.create());
    }

    public void start() {
        String inputPurchaseAmount = view.askPurchaseAmount();
        LottoPurchaseDto lottoPurchaseDto = service.buyLottery(inputPurchaseAmount);

        view.printPurchaseQuantity(lottoPurchaseDto);
        LottosDto lottosDto = service.generateLotto(lottoPurchaseDto.quantity());
        view.printLottoNumbers(lottosDto);

        String inputWinningNumber = view.askWinningNumber();

        String inputBonusNumber = view.askBonusNumber();
        WinningResultDto winningResultDto = service.generateWinningResult(
                inputWinningNumber,
                inputBonusNumber,
                lottosDto
        );

        view.printMessage(WINNING_STATS);
        view.printWinningResult(winningResultDto);
        ReturnRateDto returnRateDto = service.getReturnRate(lottoPurchaseDto, winningResultDto);
        view.printReturnRateMessage(returnRateDto);
        view.close();
    }
}
