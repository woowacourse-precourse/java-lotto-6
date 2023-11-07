package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.model.domain.LottoWinNumber;
import lotto.model.domain.Player;
import lotto.model.domain.RankingBoard;
import lotto.model.service.LottoHeadQuarter;
import lotto.model.service.LottoStore;
import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;
import lotto.model.service.RandomNumberGenerateStrategy;
import lotto.model.domain.vo.WinNumber;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;
    private ErrorView errorView;
    private LottoStore lottoStore;

    public LottoGameController(OutputView outputView, ErrorView errorView) {
        this.outputView = outputView;
        this.errorView = errorView;
        this.lottoStore = LottoStore.of(new RandomNumberGenerateStrategy());
    }

    public void run() {
        Player player = buyLotto();
        WinNumber winNumber = setWinNumber();
        BonusNumber bonusNumber = setBonusNumber();
        playLottoGame(player, winNumber, bonusNumber);
    }

    private Player buyLotto() {
        Player player = null;
        try {
            outputView.printPurchaseInput();
            Money money = new Money(input());
            player = lottoStore.sellLotto(money);
            PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(player.getLottos().getEA(), player.getLottos().getHistory());
            outputView.printPurchaseHistory(dto);
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            player = buyLotto();
        }
        outputView.printLineSeparator();
        return player;
    }

    private WinNumber setWinNumber() {
        WinNumber winNumber = null;
        try {
            outputView.printWinNumberInput();
            winNumber = WinNumber.of(input());
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            winNumber = setWinNumber();
        }
        outputView.printLineSeparator();
        return winNumber;
    }

    private BonusNumber setBonusNumber() {
        BonusNumber bonusNumber = null;
        try {
            outputView.printBonusNumberInput();
            bonusNumber = BonusNumber.of(input());
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            bonusNumber = setBonusNumber();
        }
        outputView.printLineSeparator();
        return bonusNumber;
    }

    private void playLottoGame(Player player, WinNumber winNumber, BonusNumber bonusNumber) {
        try {
            LottoHeadQuarter lottoHeadQuarter = new LottoHeadQuarter();
            LottoWinNumber lottoWinNumber = lottoHeadQuarter.pickNumber(winNumber, bonusNumber);
            RankingBoard rankingBoard = lottoHeadQuarter.drawWinner(lottoWinNumber, player.getLottos());

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
