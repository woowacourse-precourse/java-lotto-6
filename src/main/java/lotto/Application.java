package lotto;

import domain.LottoGenerator;
import domain.PurchaseInput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PurchaseInput purchaseInput = new PurchaseInput();
        LottoGenerator lottoGenerator = new LottoGenerator();

        int purchaseAmount = purchaseInput.getPurchaseAmount();
        List<List<Integer>> lottoNumbers = lottoGenerator.generateLottoNumbers(purchaseAmount);

        System.out.println("\n" + lottoNumbers.size() + "개를 구매했습니다.");
    }
}
