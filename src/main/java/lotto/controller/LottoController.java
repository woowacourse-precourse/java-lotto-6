package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoTicket;
import lotto.model.domain.MarginCalculator;
import lotto.model.domain.WinningConfirm;
import lotto.model.domain.WinningNumbers;
import lotto.model.domain.constants.LottoGameConstants;
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
        gamePrinter.printInputPurchaseAmount();
        int price = buyLotto();
        printPurchasedLotto(lottoTicket.getLottoTicket());

        gamePrinter.printInputLottoNumbers();
        Lotto lotto = saveWinningNumbers();
        gamePrinter.printInputBonusNumber();
        createWinningNumbers(lotto);

        calculateWinnings(price);
        printWinningStats();
    }

    private void printWinningStats() {
        gamePrinter.printWinningStats();
        PrizeConstants[] prizeConstantsValues = PrizeConstants.values();
        Map<PrizeConstants, Integer> prizeConstantsIntegerMap = winningConfirm.getWinningCounts();
        for (int i = LottoGameConstants.START_PRIZE.getValue(); i < prizeConstantsValues.length; i++) {
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

    private Lotto saveWinningNumbers() {
        try {
            String[] parts = Console.readLine().split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String part : parts) {
                InputValidate.isNumber(part);
                numbers.add(Integer.parseInt(part));
            }
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return saveWinningNumbers();
        }
    }


    private void createWinningNumbers(Lotto lotto) {
        try {
            String input = Console.readLine();
            InputValidate.isNumber(input);
            int bonus = Integer.parseInt(input);
            winningNumbers = new WinningNumbers(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createWinningNumbers(lotto);
        }
    }

    private void printPurchasedLotto(List<Lotto> lottoTicket) {
        gamePrinter.printPurchaseCount(lottoTicket.size());
        gamePrinter.printAmountLottos(lottoTicket);
    }

    private int buyLotto() {
        try {
            String input = Console.readLine();
            InputValidate.isNumber(input);
            int price = Integer.parseInt(input);
            lottoTicket = new LottoTicket(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }
}
