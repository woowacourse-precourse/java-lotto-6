package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.controller.dto.WinningStatisticDto;
import lotto.model.domain.LottoWinNumber;
import lotto.controller.dto.MoneyLottosDto;
import lotto.model.domain.RankingBoard;
import lotto.model.service.LottoHeadQuarter;
import lotto.model.service.LottoStore;
import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.Money;
import lotto.model.service.RandomNumberGenerateStrategy;
import lotto.model.domain.vo.WinNumber;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;
    private ErrorView errorView;
    private LottoStore lottoStore;
    private LottoHeadQuarter lottoHeadQuarter;

    public LottoGameController(OutputView outputView, ErrorView errorView) {
        this.outputView = outputView;
        this.errorView = errorView;
        this.lottoStore = LottoStore.of(new RandomNumberGenerateStrategy());
        this.lottoHeadQuarter = new LottoHeadQuarter();
    }

    public void run() {
        MoneyLottosDto moneyLottosDto = buyLotto();
        WinNumber winNumber = setWinNumber();
        BonusNumber bonusNumber = setBonusNumber();
        playLottoGame(moneyLottosDto, winNumber, bonusNumber);
    }

    private MoneyLottosDto buyLotto() {
        while (true) {
            try {
                outputView.printPurchaseInput();
                Money money = new Money(input());
                MoneyLottosDto moneyLottosDto = lottoStore.sellLotto(money);
                PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(moneyLottosDto);
                outputView.printPurchaseHistory(dto);
                outputView.printLineSeparator();
                return moneyLottosDto;
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

    private void playLottoGame(MoneyLottosDto moneyLottosDto, WinNumber winNumber, BonusNumber bonusNumber) {
        try {
            LottoWinNumber lottoWinNumber = lottoHeadQuarter.pickNumber(winNumber, bonusNumber);
            RankingBoard rankingBoard = lottoHeadQuarter.drawWinner(lottoWinNumber, moneyLottosDto.getLottos());

            double yield = lottoHeadQuarter.calculateYield(moneyLottosDto.getMoney(), rankingBoard);

            WinningStatisticDto dto = WinningStatisticDto.from(rankingBoard, yield);
            outputView.printWinningStatistic(dto);
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            setBonusNumber();
        }
    }

    private String input() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하면 안됩니다.");
        }
        return input;
    }
}
