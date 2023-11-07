package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        Store store = new Store();
        ConfirmationService confirmationService = new ConfirmationService();

        int purchaseAmount = userInterface.getValidatedPurchaseAmount();
        List<Lotto> lottos = store.getLotto(purchaseAmount);
        userInterface.printPurchaedLotto(lottos);

        confirmationService.setLottos(lottos);

        List<Integer> winningNumbers = userInterface.getValidatedWinningNumbers();

        int bonusNumber = userInterface.getValidatedBonusNUmber(winningNumbers);

        confirmationService.confirmWinnings(winningNumbers, bonusNumber);
        int winningPrizeAmount = confirmationService.getWinningPrizeAmount();
        double rate = (double)winningPrizeAmount/purchaseAmount*100;

        userInterface.printStatistics(confirmationService.getWinningCount(), rate);
    }
    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }


}
