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

        Map<Ranking,Integer> result = getRankingResult(consumerLottos,winningNumbers);
        OutView.printResult(result,ticketQuantity);
        float returnOfRate = Calculator.caculateReturnOfRate(result,ticketQuantity);
        OutView.printRateOfReturn(returnOfRate);
    }

    private int settingTicketQuantity() {
        String inputPurchaseAmount = InputView.getPurchaseAmount();
        int ticketQuantity = getTicketQuantity(inputPurchaseAmount);
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
        String inputWinningNumbers = InputView.getWinningNumbers();
        WinningNumbersValidator.validate(inputWinningNumbers);
        Lotto winningLotto = Converter.stringToLotto(inputWinningNumbers);

        String inputBonusNumber = InputView.getBonusNumber();
        BonusNumberValidator.validate(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto,bonusNumber);
        return winningNumbers;
    }

    private Map<Ranking,Integer> getRankingResult(ArrayList<Lotto> consumerLottos, WinningNumbers winningNumbers ){
        Map<Ranking,Integer> result = new TreeMap<>();
        for(Lotto lotto : consumerLottos){
            Ranking rank = Calculator.caculateRanking(lotto,winningNumbers);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        preventNullPointMap(result);
        return result;
    }

    private void preventNullPointMap(Map<Ranking, Integer> result) {
        Arrays.stream(Ranking.values())
                .filter((rank)->!result.containsKey(rank))
                .forEach((rank)->result.put(rank,0));
    }

}
