package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Buyer {
    private final LottoMachine lottoMachine;
    private final LottoResultChecker lottoResultChecker;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private int price;

    public Buyer(LottoMachine lottoMachine, LottoResultChecker lottoResultChecker) {
        this.lottoMachine = lottoMachine;
        this.lottoResultChecker = lottoResultChecker;
    }

    public void buyLotto() {
        while (true) {
            try {
                System.out.println("구매금액을 입력해 주세요.");
                String input = Console.readLine();

                int price = InputProcessor.parsePrice(input);
                InputProcessor.checkPriceValidation(price);
                this.price = price;
                this.lottos = lottoMachine.inputPurchasePrice(this.price);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void drawWinningNumbersAndBonusNumber() {
        Lotto lotto = drawWinningNumbers();
        this.winningLotto = drawBonusNumber(lotto);
    }

    private Lotto drawWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNumbers = InputProcessor.getWinningNumbers(input);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto drawBonusNumber(Lotto lotto) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                Integer bonusNumber = InputProcessor.getBonusNumber(input);
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void aggregateLotto() {
        lottoResultChecker.checkLotto(this.lottos, this.winningLotto);
        lottoResultChecker.printTotalPrize();
        lottoResultChecker.printProfit(this.price);
    }
}
