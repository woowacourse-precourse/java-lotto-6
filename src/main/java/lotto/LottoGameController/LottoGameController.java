package lotto.LottoGameController;

import lotto.MATCHING;
import lotto.domain.Lotto;
import lotto.util.Utils;
import lotto.util.Input;
import lotto.util.Output;

import java.util.*;

public class LottoGameController {

    private final Input input;
    private final Output output;
    private final Utils utils;

    private static int bonusNumber;
    private static HashMap<Integer, Integer> result;
    private static List<Lotto> lottos;
    private static Integer purchaseAmount;

    public static final Integer ANSWER_COUNT_THREE = 3;
    public static final Integer ANSWER_COUNT_FOUR = 4;
    public static final Integer ANSWER_COUNT_FIVE = 5;
    public static final Integer ANSWER_COUNT_FIVE_BONUS = 7;
    public static final Integer ANSWER_COUNT_SIX = 6;

    public LottoGameController(Input input, Output output, Utils utils) {
        this.input = input;
        this.output = output;
        this.utils = utils;
    }

    public void start() {

        purchaseAmount = input.getPurchaseAmount();
        output.printPurchaseAmount(purchaseAmount);
        lottos = createLotto(purchaseAmount);
        output.printLottoNumbers(lottos);
        HashSet<Integer> winningNumbers = input.getWinningNumbers();
        bonusNumber = input.getBonusNumber();
        getResult(winningNumbers);
        double profit = calculateProfitRate();
        output.printResult(result, profit);

    }

    private List<Lotto> createLotto(Integer purchaseAmount) {

        List<Lotto> Lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {

            List<Integer> lottoNumbers = utils.generateRandomNumbers();
            Lottos.add(new Lotto(lottoNumbers));
        }

        return Lottos;
    }

    private HashMap<Integer, Integer> getResult(HashSet<Integer> winningNumbers) {

        result = new HashMap<>();

        for (int i = 3; i <8 ; i++) {
            result.put(i,0);
        }

        for (Lotto lotto : lottos) {

            int count = lotto.countWinningNumber(winningNumbers);
            boolean containBonusNumber = lotto.checkContainNumber(bonusNumber);
            initResult(count, containBonusNumber);
        }

        return result;
    }

    private void initResult(Integer count, boolean containBonusNumber) {

        if (count < 3) {
            return;
        }

        if (count == 5 && containBonusNumber) {
            result.put(7, result.get(7) + 1);
            return;
        }

        result.put(count, result.get(count) + 1);
    }

    private double calculateProfitRate() {

        int totalPrize = 0;
        int purchaseMoney = purchaseAmount*1000;
        totalPrize += result.get(ANSWER_COUNT_THREE) * MATCHING.MATCH_THREE.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FOUR) * MATCHING.MATCH_FOUR.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FIVE) * MATCHING.MATCH_FIVE.getPrize();
        totalPrize += result.get(ANSWER_COUNT_FIVE_BONUS) * MATCHING.MATCH_FIVE_BONUS.getPrize();
        totalPrize += result.get(ANSWER_COUNT_SIX) * MATCHING.MATCH_SIX.getPrize();
        return (double) totalPrize/purchaseMoney;
    }
}
