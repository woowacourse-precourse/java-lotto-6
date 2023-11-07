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
        Tickets tickets = buyLottos();

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

    private Tickets buyLottos() {
        String input = InputView.PurchaseAmount();
        try {
            int userMoney = parseStringToUnsignedInt(input);
            return lottoGameService.getTickets(userMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos();
        }
    }

    private int getBonusNumber(Lotto winningLottoNumber) {
        String bonusNumber = InputView.BonusNumber();
        try {
            int bonusNumberInt = Integer.parseUnsignedInt(bonusNumber);
            if(winningLottoNumber.checkDuplicate(bonusNumberInt)){
                throw new IllegalArgumentException("[ERROR]보너스 번호는 당첨 번호와 중복될 수 없습니다");
            }
            if(bonusNumberInt < 1 || bonusNumberInt > 45) {
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
                .map(Integer::parseInt)
                .toList());
        } catch (IllegalArgumentException e) {
            return parseStringToLotto(InputView.WinningNumber());
        }
    }

    private int parseStringToUnsignedInt(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]0이상의 숫자만 입력가능합니다");
            return parseStringToUnsignedInt(InputView.PurchaseAmount());
        }
    }
}
