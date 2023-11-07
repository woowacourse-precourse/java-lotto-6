package lotto.model;

import lotto.utils.LottoNumberGenerator;
import lotto.constants.MessageConstants;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private int firstPlaceCount = 0, secondPlaceCount = 0, thirdPlaceCount = 0, fourthPlaceCount = 0, fifthPlaceCount = 0;

    public void run() {
        Integer purchaseAmount = InputView.inputPurchaseAmount();
        createLottos(purchaseAmount);
        printLottoNumbers();

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();

        checkLottoWinningRank(winningNumbers, bonusNumber);
        printRank();

        incomeRate(purchaseAmount);
    }

    private void incomeRate(Integer purchaseAmount) {
        Double sum = (double) (firstPlaceCount * 2000000000 + secondPlaceCount * 30000000 + thirdPlaceCount * 1500000 + fourthPlaceCount * 50000 + fifthPlaceCount * 5000);
        Double per = ((sum - purchaseAmount) / purchaseAmount) * 100.;
        per = 100 + per;
        per = Math.round(per * 10) / 10.;

        System.out.println("총 수익률은 " + per + "%입니다.");
    }

    private void checkLottoWinningRank(List<Integer> winningNumbers, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkLottoWinningRank(winningNumbers, bonusNumber);
            if (rank == Rank.FIRST_PLACE) {
                firstPlaceCount += 1;
            } else if (rank == Rank.SECOND_PLACE) {
                secondPlaceCount += 1;
            } else if (rank == Rank.THIRD_PLACE) {
                thirdPlaceCount += 1;
            } else if (rank == Rank.FOURTH_PLACE) {
                fourthPlaceCount += 1;
            } else if (rank == Rank.FIFTH_PLACE) {
                fifthPlaceCount += 1;
            }
        }
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
        System.out.println(MessageConstants.THREE_MATCH + fifthPlaceCount + "개");
        System.out.println(MessageConstants.FOUR_MATCH + fourthPlaceCount + "개");
        System.out.println(MessageConstants.FIVE_MATCH + thirdPlaceCount + "개");
        System.out.println(MessageConstants.FIVE_BONUS_MATCH + secondPlaceCount + "개");
        System.out.println(MessageConstants.SIX_MATCH + firstPlaceCount + "개");
    }

}
