package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.controller.dto.WinningStatisticDto;
import lotto.model.domain.LottoWinNumber;
import lotto.model.domain.RankingBoard;
import lotto.model.domain.vo.Lottos;
import lotto.model.service.LottoGameService;
import lotto.model.service.LottoStoreService;
import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.Money;
import lotto.model.domain.vo.WinNumber;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;
    private ErrorView errorView;
    private LottoStoreService lottoStoreService;
    private LottoGameService lottoGameService;

    public LottoGameController(OutputView outputView,
            ErrorView errorView,
            LottoStoreService lottoStoreService,
            LottoGameService lottoGameService) {
        this.outputView = outputView;
        this.errorView = errorView;
        this.lottoStoreService = lottoStoreService;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        Money money = inputNumber();
        Lottos lottos = buyLotto(money);
        WinNumber winNumber = setWinNumber();
        BonusNumber bonusNumber = setBonusNumber();
        playLottoGame(money, lottos, winNumber, bonusNumber);
    }

    private String input() {
        String input = Console.readLine();
        validateBlank(input);
        return input;
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하면 안됩니다.");
        }
    }

    private Money inputNumber() {
        while (true) {
            try {
                outputView.printPurchaseInput();
                Money money = new Money(input());
                return money;
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lottos buyLotto(Money money) {
        while (true) {
            try {
                Lottos lottos = lottoStoreService.sellLotto(money);
                PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(lottos);
                outputView.printPurchaseHistory(dto);
                outputView.printLineSeparator();
                return lottos;
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinNumber setWinNumber() {
        while (true) {
            try {
                outputView.printWinNumberInput();
                WinNumber winNumber = WinNumber.of(input());
                outputView.printLineSeparator();
                return winNumber;
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber setBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberInput();
                BonusNumber bonusNumber = BonusNumber.of(input());
                outputView.printLineSeparator();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void playLottoGame(Money money, Lottos lottos, WinNumber winNumber, BonusNumber bonusNumber) {
        try {
            LottoWinNumber lottoWinNumber = lottoGameService.pickNumber(winNumber, bonusNumber);
            RankingBoard rankingBoard = lottoGameService.drawWinner(lottoWinNumber, lottos);

            double yield = lottoGameService.calculateYield(money, rankingBoard);

            WinningStatisticDto dto = WinningStatisticDto.from(rankingBoard, yield);
            outputView.printWinningStatistic(dto);
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            setBonusNumber();
        }
    }
}
