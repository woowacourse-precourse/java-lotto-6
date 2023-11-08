package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    Input input = new Input();
    Print print = new Print();
    Lottos lottos;
    Winning winning;
    int purchasePrice = 0;
    int lottoCount = 0;
    int firstCount = 0;
    int secondCount = 0;
    int thirdCount = 0;
    int fourthCount = 0;
    int fifthCount = 0;

    public void playLottoGame() {
        purchasePrice = input.inputPurchasePrice();
        getLottoCountByPurchasePrice(purchasePrice);
        lottos = getLottoNumbers(lottoCount);
        winning = input.inputWinning();
        getResult(lottos.getLottos(), winning.getWinningNumbers(), winning.getBonusNumber());
        print.printResult(firstCount, secondCount, thirdCount, fourthCount, fifthCount);
        String revenueRate = getRevenueRate(purchasePrice);
        print.printRevenueRate(revenueRate);
    }

    private void getLottoCountByPurchasePrice(int price) {
        lottoCount = price / 1000;
        print.printLottoCount(lottoCount);
    }

    private Lottos getLottoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            print.printLottoNumbers(lotto);
            lottos.add(lotto);
        }
        System.out.println();
        return new Lottos(lottos);
    }

    private void getResult(List<Lotto> lottos, List<Integer> winning, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int num = countMatchingNumber(lotto.getNumbers(), winning);
            if (num == 6)
                fifthCount++;
            if (num == 5 && lotto.getNumbers().contains(bonusNumber))
                secondCount++;
            if (num == 5 && !lotto.getNumbers().contains(bonusNumber))
                thirdCount++;
            if (num == 4)
                fourthCount++;
            if (num == 3)
                fifthCount++;
        }
    }

    private int countMatchingNumber(List<Integer> lotto, List<Integer> winning) {
        int count = 0;
        for (int winningNumber : winning) {
            if (lotto.contains(winningNumber)) count++;
        }
        return count;
    }

    private String getRevenueRate(int purchasePrice) {
        int totalRevenue = 5000 * fifthCount + 50000 * fourthCount + 1500000 * thirdCount + 30000000 * secondCount + 2000000000 * firstCount;
        double revenueRate = (double) totalRevenue / purchasePrice * 100;
        return formatRevenueRate(revenueRate);
    }

    private String formatRevenueRate(double revenueRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(revenueRate);
    }
}
