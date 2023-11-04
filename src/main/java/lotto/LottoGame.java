package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.utils.Converter;
import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.WinningNumbersValidator;

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

    private int settingTicketQuantity() {
        int ticketQuantity;
        while (true) {
            try {
                String inputPurchaseAmount = InputView.getPurchaseAmount();
                ticketQuantity = getTicketQuantity(inputPurchaseAmount);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return ticketQuantity;
    }

    private int getTicketQuantity(String inputValue) {
        return purchaseAmountCalculator.getTicketQuantity(inputValue);
    }

    private ArrayList<Lotto> settingConsumerLottos(int ticketQuantity) {
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

    private static WinningNumbers settingWinningNumbers() {
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
