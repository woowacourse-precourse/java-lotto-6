package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            User user = new User();
            int purchasingAmount = user.getPurchaseAmount();

            LottoManager lottoManager = new LottoManager(purchasingAmount);

            List<Integer> winningNumbers = user.getWinningNumbers();
            int bonusNumber = user.getBonusNumber();

            int[] resultCounts = lottoManager.countLotto(winningNumbers, bonusNumber);
            int totalPrize = lottoManager.calcuateTotalLotto(resultCounts);
            lottoManager.printProfit(totalPrize, purchasingAmount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
