package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoTicket;
import lotto.model.domain.MarginCalculator;
import lotto.model.domain.WinningConfirm;
import lotto.model.domain.WinningNumbers;
import lotto.model.domain.constants.PrizeConstants;
import lotto.view.GamePrinter;

public class LottoController {
    private final GamePrinter gamePrinter;
    private LottoTicket lottoTicket;
    private WinningNumbers winningNumbers;
    private WinningConfirm winningConfirm;
    private MarginCalculator marginCalculator;

    public LottoController() {
        this.gamePrinter = new GamePrinter();
    }

    public void start() {
        int price = buyLotto();
        printPurchasedLotto(lottoTicket.getLottoTicket());
        saveWinningNumbers();
        calculateWinnings(price);
        printWinningStats();
    }

    private void printWinningStats() {
        gamePrinter.printWinningStats();
        PrizeConstants[] prizeConstantsValues = PrizeConstants.values();
        Map<PrizeConstants, Integer> prizeConstantsIntegerMap = winningConfirm.getWinningCounts();
        for (int i = 3; i < prizeConstantsValues.length; i++) {
            if (prizeConstantsValues[i] == PrizeConstants.FIVE_MATCH_WITH_BONUS) {
                gamePrinter.printMatchBonusStats(
                        i,
                        prizeConstantsValues[i].getPrize(),
                        prizeConstantsIntegerMap.getOrDefault(prizeConstantsValues[i], 0));
                continue;
            }
            gamePrinter.printMatchStats(
                    i,
                    prizeConstantsValues[i].getPrize(),
                    prizeConstantsIntegerMap.getOrDefault(prizeConstantsValues[i], 0)); // 지금 여기서 당첨이 안된애들은 null이 된다

        }
        gamePrinter.printTotalProfitRate(marginCalculator);
    }

    private void calculateWinnings(int price) {
        winningConfirm = new WinningConfirm(lottoTicket.getLottoTicket(), winningNumbers);
        marginCalculator = new MarginCalculator(price, winningConfirm);
    }

    private void saveWinningNumbers() {
        gamePrinter.printInputLottoNumbers();
        String[] parts = Console.readLine().split(",");
        List<Integer> winningNum = Arrays.stream(parts)
                .map(Integer::parseInt)
                .toList();
        gamePrinter.printInputBonusNumber();
        int bonusNum = Integer.parseInt(Console.readLine());
        winningNumbers = new WinningNumbers(new Lotto(winningNum), bonusNum);
    }

    private void printPurchasedLotto(List<Lotto> lottoTicket) {
        gamePrinter.printPurchaseCount(lottoTicket.size());
        gamePrinter.printAmountLottos(lottoTicket);
    }

    private int buyLotto() {
        gamePrinter.printInputPurchaseAmount();
        String input;
        try {
            input = Console.readLine();
            InputValidate.isNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
        int price = Integer.parseInt(input);
        lottoTicket = new LottoTicket(price);
        return price;
    }
}
