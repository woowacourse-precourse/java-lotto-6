package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {



    public LottoGame() {

    }

    public void startGame() {
        int purchaseAmount = getPurchaseAmount();

        ArrayList<Lotto> lottos = LottoMachine.buyLotto(purchaseAmount);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(Lotto::printNumbers);

    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        isValidAmount(purchaseAmount);

        return purchaseAmount;
    }

    private void isValidAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

}
