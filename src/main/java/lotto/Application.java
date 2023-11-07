package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new LottoMachine());

        Money purchaseAmount = enterPurchaseAmount();
        Lottos lottos = lottoStore.purchaseLottos(purchaseAmount);

        System.out.println(lottos.count() + "개를 구매했습니다.");
        lottos.print();

        WinningLotto winningLotto = enterWinningLotto();

        LottoResult lottoResult = new LottoResult(winningLotto, lottos);

        ResultsPrinter resultsPrinter = new ResultsPrinter(lottoResult);
        resultsPrinter.printResults();
        resultsPrinter.printProfitRate(purchaseAmount);
    }

    private static Money enterPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine().trim();
                return Money.of(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningLotto enterWinningLotto() {
        String[] winningNumbersInput = enterWinningNumbers();
        int bonusNumber = enterBonusNumber();
        return new WinningLotto(winningNumbersInput, bonusNumber);
    }

    private static String[] enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    private static int enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}
