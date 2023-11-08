package lotto;

import java.util.List;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        Buyer buyer = new Buyer(lottoMachine, lottoResultChecker);

        int price = getInput("구매금액을 입력해 주세요.", InputProcessor::parsePrice);
        buyer.buyLotto(price);

        List<Integer> winningNumbers = getInput("당첨 번호를 입력해 주세요.", InputProcessor::getWinningNumbers);
        Integer bonusNumber = getInput("보너스 번호를 입력해 주세요.", InputProcessor::getBonusNumber);
        buyer.drawWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        buyer.aggregateLotto();
    }

    private static <T> T getInput(String message, Function<String, T> parser) {
        while (true) {
            try {
                return parser.apply(LottoUI.readLine(message));
            } catch (IllegalArgumentException e) {
                LottoUI.printMessage(e.getMessage());
            }
        }
    }
}
