package lotto.model;

import lotto.utils.LottoNumberGenerator;
import lotto.constants.MessageConstants;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private Map<Rank, Integer> rankMap = new HashMap<>();

    public void run() {
        Integer purchaseAmount = InputView.inputPurchaseAmount();
        createLottos(purchaseAmount);
        printLottoNumbers();

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();

        checkLottoWinningRank(winningNumbers, bonusNumber);
        printRank();

        calculateIncomeRate(purchaseAmount);
    }

    private void calculateIncomeRate(Integer purchaseAmount) {
        Double incomeAmount = (double) (rankMap.get(Rank.FIRST_PLACE) * 2000000000 + rankMap.get(Rank.SECOND_PLACE) * 30000000 + rankMap.get(Rank.THIRD_PLACE) * 1500000 + rankMap.get(Rank.FOURTH_PLACE) * 50000 + rankMap.get(Rank.FIFTH_PLACE) * 5000);
        Double incomeRate = ((incomeAmount - purchaseAmount) / purchaseAmount) * 100.;
        incomeRate = 100 + incomeRate;
        incomeRate = Math.round(incomeRate * 10) / 10.;

        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }

    private void checkLottoWinningRank(List<Integer> winningNumbers, Integer bonusNumber) {
        rankMapInit();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkLottoWinningRank(winningNumbers, bonusNumber);
            rankMap.put(rank, rankMap.get(rank) + 1);
        }
    }

    private void rankMapInit() {
        rankMap.put(Rank.FIRST_PLACE, 0);
        rankMap.put(Rank.SECOND_PLACE, 0);
        rankMap.put(Rank.THIRD_PLACE, 0);
        rankMap.put(Rank.FOURTH_PLACE, 0);
        rankMap.put(Rank.FIFTH_PLACE, 0);
        rankMap.put(Rank.OTHER_PLACE, 0);
    }

    private void createLottos(Integer purchaseAmount) {
        System.out.println("\n" + purchaseAmount / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.run());
            lottos.add(lotto);
        }
    }

    private void printLottoNumbers() {
        lottos.stream()
                .forEach(lotto -> lotto.printNumbers());
    }

    private void printRank() {
        System.out.println(MessageConstants.WINNING_GUIDE);
        System.out.println(MessageConstants.THREE_MATCH + rankMap.get(Rank.FIFTH_PLACE) + "개");
        System.out.println(MessageConstants.FOUR_MATCH + rankMap.get(Rank.FOURTH_PLACE) + "개");
        System.out.println(MessageConstants.FIVE_MATCH + rankMap.get(Rank.THIRD_PLACE) + "개");
        System.out.println(MessageConstants.FIVE_BONUS_MATCH + rankMap.get(Rank.SECOND_PLACE) + "개");
        System.out.println(MessageConstants.SIX_MATCH + rankMap.get(Rank.FIRST_PLACE) + "개");
    }

}
