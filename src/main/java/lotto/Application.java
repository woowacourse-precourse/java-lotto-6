package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Customer customer = new Customer();
        LottoStore lottoStore = new LottoStore();
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        customer.insertMoney(lottoStore, money);

        lottoStore.sellLottos(customer);
        long lottoAmounts = lottoStore.getLottoAmount();
        System.out.println(lottoAmounts + "개를 구매했습니다.");
        List<Lotto> lottos = lottoStore.showLottoPapers();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        winningNumbersGenerator.generateWinningNumbers(winningNumber);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        winningNumbersGenerator.generateBonusNumber(bonusNumber);

        LottoChecker lottoChecker= new LottoChecker(
                winningNumbersGenerator.getWinningNumbers(),
                winningNumbersGenerator.getBonusNumber()
        );
        lottoChecker.insertLottos(lottos);
        lottoChecker.saveLottosResult();
        lottoChecker.calculateTotalPrize();
        lottoChecker.calculateProfitRate();

        Map<Prize, Integer> result = lottoChecker.getResult();
        String profitRate = lottoChecker.getProfitRate();
        System.out.println("당첨 통계\n" + "---");
        for (Prize prize : result.keySet()) {
            System.out.println(Prize.prizeInfo(prize) + " - " + result.get(prize) +"개");
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
