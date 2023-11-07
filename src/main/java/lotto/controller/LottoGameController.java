package lotto.controller;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        Tickets tickets = buyTickets();

        OutputView.printNumberOfTickets(tickets.getNumberOfTickets());

        Lottos lottos = lottoGameService.buyLottos(tickets);

        OutputView.printLottoNumbers(lottos);

        String winningNumber = InputView.WinningNumber();

        Lotto winningLottoNumber = parseStringToLotto(winningNumber);

        int bonusNumber = getBonusNumber(winningLottoNumber);

        Result[] results = Result.getAllLottoResult(lottos, winningLottoNumber, bonusNumber);

        OutputView.printWinningStatistics(results);

        double profitRate = Result.getProfitRate(results, tickets.getUserMoney());

        OutputView.printProfitRate(profitRate);
    }

    private Tickets buyTickets() {
        String input = InputView.PurchaseAmount();
        try {
            int userMoney = parseStringToUnsignedInt(input);
            return Tickets.buyTickets(userMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyTickets();
        }
    }

    private int getBonusNumber(Lotto winningLottoNumber) {
        String bonusNumber = InputView.BonusNumber();
        try {
            int bonusNumberInt = parseStringToUnsignedInt(bonusNumber);
            if (winningLottoNumber.checkDuplicate(bonusNumberInt)) {
                throw new IllegalArgumentException("[ERROR]보너스 번호는 당첨 번호와 중복될 수 없습니다");
            }
            if (bonusNumberInt < 1 || bonusNumberInt > 45) {
                throw new IllegalArgumentException("[ERROR]1~45 사이의 숫자만 입력가능합니다");
            }
            return bonusNumberInt;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningLottoNumber);
        }
    }

    private Lotto parseStringToLotto(String input) {
        try {
            return Lotto.of(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::parseStringToUnsignedInt)
                .toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return parseStringToLotto(InputView.WinningNumber());
        }
    }

    private int parseStringToUnsignedInt(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]숫자만 입력 가능합니다");
        }
    }
}
