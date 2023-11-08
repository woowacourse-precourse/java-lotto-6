package lotto.input;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.message.InputMessage;
import lotto.util.message.OutputMessage;

import static lotto.util.Constant.LOTTO_PRICE;

public class InputHandler {

    private final Parser parser = new Parser();

    public int getPurchasedPrice() {
        int purchasedPrice = getPurchasedAmount();
        OutputMessage.purchaseAmount(purchasedPrice / LOTTO_PRICE);
        return purchasedPrice;
    }

    public Lotto getWinningLotto() {
        InputMessage.requestWinningNumbers();
        List<Integer> winningNumbers = parser.parseWinningNumbers(Console.readLine());
        OutputMessage.newLine();
        return new Lotto(winningNumbers);
    }

    public int getBonusNumber(Lotto winningLotto) {
        InputMessage.requestBonusNumber();
        String inputBonusNumber = Console.readLine();
        OutputMessage.newLine();
        return parser.parseBonusNumber(inputBonusNumber, winningLotto);
    }

    private int getPurchasedAmount() {
        InputMessage.requestAmount();
        return parser.parsePurchaseAmount();
    }
}
