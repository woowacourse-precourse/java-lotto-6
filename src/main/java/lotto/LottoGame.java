package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private int firstPlaceCount, secondPlaceCount, thirdPlaceCount, fourthPlaceCount, fifthPlaceCount;

    public void run() {
        Integer purchaseAmount = InputView.inputPurchaseAmount();
        createLottos(purchaseAmount);
        printLottoNumbers();

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();

        checkLottoWinningRank(winningNumbers, bonusNumber);
        printRank();
    }

    private void checkLottoWinningRank(List<Integer> winningNumbers, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkLottoWinningRank(winningNumbers, bonusNumber);
            if(rank == Rank.FIRST_PLACE) {
                firstPlaceCount += 1;
            } else if(rank == Rank.SECOND_PLACE) {
                secondPlaceCount += 1;
            } else if(rank == Rank.THIRD_PLACE) {
                thirdPlaceCount += 1;
            } else if(rank == Rank.FOURTH_PLACE) {
                fourthPlaceCount += 1;
            } else if(rank == Rank.FIFTH_PLACE) {
                fifthPlaceCount += 1;
            }
        }
    }

    private void createLottos(Integer purchaseAmount) {
        System.out.println("\n" + purchaseAmount /1000 + "개를 구매했습니다.");
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
