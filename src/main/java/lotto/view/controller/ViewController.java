package lotto.view.controller;

import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;
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

    public void printRandomLottos(List<LottoDto> lottoDtos) {
        viewOutputService.printPurchasedCount(lottoDtos);
    }

    public List<Integer> inputWinnerNumbers() {
        // 당첨 번호 입력 요구 메세지
        viewInputService.printMessageWinningNumbers();
        // 당첨 번호 입력
        return viewInputService.inputWinningNumbers();
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        // 보너스 번호 입력 요구 메세지
        viewInputService.printMessageBonusNumber();
        // 보너스 번호 입력
        return viewInputService.inputBonusNumber(winningNumbers);
    }

    public void printTotalStatistics(ResultDto resultDto) {
        viewOutputService.printTotalStatistics(resultDto);
    }
}
