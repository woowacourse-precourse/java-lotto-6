package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private int purchaseAmount;
    private List<Lotto> lotties;

    void inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.getInteger(Console.readLine());
    }

    void createLotties() {
        lotties = new ArrayList<>();
        NumberGenerator numberGenerator = new NumberGenerator();
        int lottoPrice = 1000;
        for(int i = 0; i < this.purchaseAmount/lottoPrice; i++) {
            List<Integer> numbers = numberGenerator.createRandomNumbers();
            lotties.add(new Lotto(numbers));
        }
    }
}
