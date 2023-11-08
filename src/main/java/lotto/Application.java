package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        Buyer buyer = new Buyer(lottoMachine, lottoResultChecker);

        int price = InputProcessor.parsePrice(LottoUI.readLine("구매금액을 입력해 주세요."));
        buyer.buyLotto(price);

        List<Integer> winningNumbers = InputProcessor.getWinningNumbers(LottoUI.readLine("구매금액을 입력해 주세요."));
        Integer bonusNumber = InputProcessor.getBonusNumber(LottoUI.readLine("보너스 번호를 입력해 주세요."));
        buyer.drawWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        buyer.aggregateLotto();
    }
}
