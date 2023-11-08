package lotto;

import input.BonusNumber;
import input.Purchase;
import input.WinningNumber;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import output.LottoPrinter;
import output.LottoResult;
import output.TotalProfitPrinter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구매 금액 입력받기
        Purchase purchase = new Purchase();
        int money = purchase.getMoney();

        // 금액 만큼 천원당 하나의 로또 구매
        List<List<Integer>> lottos = Lotto.getLottos(money);
        // 구매한 로또 출력
        LottoPrinter.printLottos(lottos);

        WinningNumber wn = new WinningNumber();
        // 당첨 번호 입력받아 저장
        List<Integer> winningNumbers = wn.getWinningNumbers();

        BonusNumber bn = new BonusNumber(winningNumbers);
        // 보너스 번호 입력받아 저장
        int bonusNumber = bn.getBonnusNumber();
        winningNumbers.add(bonusNumber);

        LinkedHashMap<String, Integer> results = LottoResult.countResultLotto(lottos, winningNumbers);

        TotalProfitPrinter.printResult(results, money);

    }
}
