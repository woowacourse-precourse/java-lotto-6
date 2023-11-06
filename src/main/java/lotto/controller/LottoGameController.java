package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.model.LottoStore;
import lotto.model.vo.Money;
import lotto.model.Player;
import lotto.model.RandomNumberGenerateStrategy;
import lotto.model.vo.WinNumber;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class LottoGameController {

    private OutputView outputView;
    private ErrorView errorView;

    public LottoGameController(OutputView outputView, ErrorView errorView) {
        this.outputView = outputView;
        this.errorView = errorView;
    }

    public void run() {
        Player player = buyLotto();
        setWinNumber();
    }

    private void setWinNumber() {
        try {
            outputView.printWinNumberInput();
            WinNumber winNumber = WinNumber.of(input());
            winNumber.getWinNumber().stream()
                    .forEach((num) -> System.out.print(num + " "));
        } catch (NumberFormatException e) {
            errorView.printErrorMessage("숫자 형식이 아닙니다.");
            setWinNumber();
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            buyLotto();
        }
    }

    private Player buyLotto() {
        Player player = null;
        try {
            // 구입 금액 입력
            outputView.printPurchaseInput();
            Money money = new Money(input());
            player = Player.of(money);
            // 로또 구매
            player.buyLotto(LottoStore.of(new RandomNumberGenerateStrategy()));
            // 로또 번호 반환 및 출력
            PurchaseHistoryDto dto = PurchaseHistoryDto.toDto(player.getEA(), player.getHistory());
            outputView.printPurchaseHistory(dto);
        } catch (NumberFormatException e) {
            errorView.printErrorMessage("숫자 형식이 아닙니다.");
            buyLotto();
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            buyLotto();
        }
        return player;
    }

    private String input() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하면 안됩니다.");
        }
        return input;
    }
}
