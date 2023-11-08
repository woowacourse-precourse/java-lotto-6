package lotto;

import domain.LottoGenerator;
import domain.LottoPrinter;
import domain.PurchaseInput;
import domain.WinningNumbers;
import enums.LottoScore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        PurchaseInput purchaseInput = new PurchaseInput();
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningNumbers winningNumbers = new WinningNumbers();

        int purchaseAmount = purchaseInput.getPurchaseAmount();
        List<Lotto> lottoNumbers = lottoGenerator.generateLottoNumbers(purchaseAmount);

        System.out.println("\n" + lottoNumbers.size() + "개를 구매했습니다.");
        LottoPrinter.printFormattedLottoNumbers(lottoNumbers);

        winningNumbers.inputWinningNumbers();
        winningNumbers.inputBonusNumber();

        Map<LottoScore, Integer> scoreCountMap = new HashMap<>();

        for (int i = 0; i < lottoNumbers.size(); i++) {
            LottoScore score = lottoNumbers.get(i).calculate(winningNumbers.getWinningNumbers(), winningNumbers.getBonusNumber());
            scoreCountMap.put(score, scoreCountMap.getOrDefault(score, 0) + 1);
        }
    }
}
