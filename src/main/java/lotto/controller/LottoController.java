package lotto.controller;

import static lotto.constant.Message.WINNING_STATS;

import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.dto.ReturnRateDto;
import lotto.dto.WinningResultDto;
import lotto.service.Service;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final Service service;

    private LottoController(final View view, final Service service) {
        this.view = view;
        this.service = service;
    }

    public static LottoController from(final View view, final Service service) {
        return new LottoController(view, service);
    }

    public void start() {
        LottoPurchaseDto lottoPurchaseDto = purchaseLotto();
        LottosDto lottosDto = generateLottos(lottoPurchaseDto);
        WinningResultDto winningResultDto = drawLotto(lottosDto);
        showWinningStats(winningResultDto, lottoPurchaseDto);
    }

    private LottoPurchaseDto purchaseLotto() {
        String inputPurchaseAmount = view.askPurchaseAmount();
        return service.buyLottery(inputPurchaseAmount);
    }

    private LottosDto generateLottos(LottoPurchaseDto lottoPurchaseDto) {
        view.printPurchaseQuantity(lottoPurchaseDto);
        LottosDto lottosDto = service.generateLotto(lottoPurchaseDto.quantity());
        view.printLottoNumbers(lottosDto);
        return lottosDto;
    }

    private WinningResultDto drawLotto(LottosDto lottosDto) {
        String inputWinningNumber = view.askWinningNumber();
        String inputBonusNumber = view.askBonusNumber();
        return service.generateWinningResult(
                inputWinningNumber,
                inputBonusNumber,
                lottosDto
        );
    }

    private void showWinningStats(WinningResultDto winningResultDto, LottoPurchaseDto lottoPurchaseDto) {
        view.printMessage(WINNING_STATS);
        view.printWinningResult(winningResultDto);
        ReturnRateDto returnRateDto = service.getReturnRate(lottoPurchaseDto, winningResultDto);
        view.printReturnRateMessage(returnRateDto);
        view.close();
    }
}
