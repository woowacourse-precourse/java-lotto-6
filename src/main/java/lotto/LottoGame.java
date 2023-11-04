package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.PurchaseAmountCalculator;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;
import lotto.utils.Converter;
import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoGame {

    PurchaseAmountCalculator purchaseAmountCalculator;
    LottoNumbersGenerator lottoNumbersGenerator;

    public LottoGame() {
        this.purchaseAmountCalculator = new PurchaseAmountCalculator();
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }


    public void run() {
        int ticketQuantity = settingTicketQuantity();
        OutView.printTickekQuantity(ticketQuantity);

        ArrayList<Lotto> consumerLottos = settingConsumerLottos(ticketQuantity);
        OutView.printConsumerLottos(consumerLottos);

        WinningNumbers winningNumbers = settingWinningNumbers();

        Map<Ranking, Integer> result = getRankingResult(consumerLottos, winningNumbers);
        OutView.printResult(result, ticketQuantity);
        float returnOfRate = Calculator.caculateReturnOfRate(result, ticketQuantity);
        OutView.printRateOfReturn(returnOfRate);
    }

    public int settingTicketQuantity() {
        int ticketQuantity = 0;
        while (ticketQuantity == 0) {
            try {
                String inputPurchaseAmount = InputView.getPurchaseAmount();
                ticketQuantity = getTicketQuantity(inputPurchaseAmount);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return ticketQuantity;
    }

    private int getTicketQuantity(String inputValue) {
        return purchaseAmountCalculator.getTicketQuantity(inputValue);
    }

    public ArrayList<Lotto> settingConsumerLottos(int ticketQuantity) {
        ArrayList<Lotto> consumerLottos = new ArrayList<>();
        publishLottoByTicketQuantity(ticketQuantity, consumerLottos);
        return consumerLottos;
    }

    private void publishLottoByTicketQuantity(int ticketQuantity, ArrayList<Lotto> lottos) {
        while (ticketQuantity-- > 0) {
            List<Integer> randomNumbers = lottoNumbersGenerator.generateRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
    }

    public static WinningNumbers settingWinningNumbers() {
        Lotto winningLotto = settingMainNumbers();

        WinningNumbers winningNumbers = getBonusNumber(winningLotto);

        return winningNumbers;
    }

    private static WinningNumbers getBonusNumber(Lotto winningLotto) {
        WinningNumbers winningNumbers = null;
        while (winningNumbers == null) {
            try {
                int bonusNumber = settingBonusNumber();
                winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return winningNumbers;
    }

    private static int settingBonusNumber() {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            try {
                String inputBonusNumber = InputView.getBonusNumber();
                BonusNumberValidator.validate(inputBonusNumber);
                bonusNumber = Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return bonusNumber;
    }

    private static Lotto settingMainNumbers() {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            try {
                String inputWinningNumbers = InputView.getWinningNumbers();
                WinningNumbersValidator.validate(inputWinningNumbers);
                winningLotto = Converter.stringToLotto(inputWinningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return winningLotto;
    }

    private Map<Ranking, Integer> getRankingResult(ArrayList<Lotto> consumerLottos, WinningNumbers winningNumbers) {
        Map<Ranking, Integer> result = new TreeMap<>();
        for (Lotto lotto : consumerLottos) {
            Ranking rank = Calculator.caculateRanking(lotto, winningNumbers);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        preventNullPointMap(result);
        return result;
    }

    private void preventNullPointMap(Map<Ranking, Integer> result) {
        Arrays.stream(Ranking.values())
                .filter((rank) -> !result.containsKey(rank))
                .forEach((rank) -> result.put(rank, 0));
    }

}
