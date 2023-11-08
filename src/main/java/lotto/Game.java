package lotto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private LottoGenerator lottoGenerator;
    private ResultChecker resultChecker;
    private InputResolver inputResolver;

    public Game() {
        lottoGenerator = new LottoGenerator();
        resultChecker = new ResultChecker();
        inputResolver = new InputResolver();
    }

    public void play() {
        Integer price = inputResolver.getPriceInput();
        Integer quantity = inputResolver.getPurchaseQuantity(price);
        List<Lotto> lottos = lottoGenerator.makeLottoNumbers(quantity);
        printPurchasedLotto(lottos);

        List<Integer> winningNumbers = inputResolver.getWinningNumbersInput();
        Integer bonus = inputResolver.getBonusNumberInput();
        WinningLotto winningLotto = lottoGenerator.getWinningLotto(winningNumbers, bonus);
        HashMap<Rank, Integer> results = resultChecker.checkLottoResult(lottos, winningLotto);
        printResults(results);
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.print("[");
            List<Integer> numbers = lotto.getNumbers();
            printNumberList(numbers);
            System.out.println("]");
        }
    }

    public void printResults(HashMap<Rank, Integer> results) {
        results.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    Rank rank = entry.getKey();
                    int count = entry.getValue();
                    String amount = rank.getPrizeAmountWon();
                    String description = rank.getDescription();
                    System.out.println(description + " (" + amount + ") - " + count +"개");
                });
        BigDecimal profit = resultChecker.calculateProfit(results);
        String profitFormatted = getFormattedNumber(profit);
        System.out.println("총 수익률은 "+ profitFormatted + "%입니다.");
    }
    private String getFormattedNumber(BigDecimal number){
        DecimalFormat format = new DecimalFormat("###,###");
        String formattedNumber = format.format(number);
        return formattedNumber;
    }

    private void printNumberList(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
