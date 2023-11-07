package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        Store store = new Store();

        int purchaseAmount = userInterface.getPurchaseAmount();
        List<Lotto> lottos = store.getLotto(purchaseAmount);
        userInterface.printPurchaedLotto(lottos);
        ConfirmationService confirmationService = new ConfirmationService(lottos);

        List<Integer> winningNumbers = userInterface.getWinningNumber();
        int bonusNumber = userInterface.getBonusNumber();

        confirmationService.confirmWinnings(winningNumbers, bonusNumber);
        int winningPrizeAmount = confirmationService.getWinningPrizeAmount();
        double rate = (double)winningPrizeAmount/purchaseAmount*100;

        userInterface.printStatistics(confirmationService.getWinningCount(), rate);
    }
}
