package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.LottoException;

public class InputView {

    private final LottoException lottoException = new LottoException();

    private final LottoConfig lottoConfig = new LottoConfig();

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String USER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String USER_INPUT_SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    public int purchaseAmountInput() {
        String purchaseAmount;

        do {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            purchaseAmount = Console.readLine().trim();
        } while (!lottoException.numberCheck(purchaseAmount) ||
                !lottoException.purchaseAmountCheckMain(purchaseAmount));
        {
            System.out.print(NEW_LINE);
            return Integer.parseInt(purchaseAmount);
        }
    }

    public int lottoAmount() {
        int purchaseAmount = purchaseAmountInput();
        int count = purchaseAmount / lottoConfig.TICKET_PRICE;
        System.out.println(count + PURCHASE_MESSAGE);
        return count;
    }

    public WinningLotto winningLottoInput() {
        List<Integer> winningNumber;
        String userInput;

        do {
            System.out.println(USER_INPUT_MESSAGE);
            userInput = Console.readLine();
            winningNumber = convertWinningNumber(userInput);
        } while (!lottoException.numberLengthCheckMain(winningNumber));
        return new WinningLotto(new Lotto(winningNumber), 1);
    }

    public List<Integer> convertWinningNumber(String userInput) {
        String[] splitInput = userInput.split(USER_INPUT_SEPARATOR);
        return Arrays.stream(splitInput)
                .map(String::trim)
                .distinct()
                .filter(lottoException::numberCheck)
                .map(Integer::parseInt)
                .filter(lottoException::lottoRangeCheckMain)
                .sorted()
                .collect(Collectors.toList());
    }

    public int bonusNumberInput(List<Integer> winningNumber) {
        String userInput;
        do {
            System.out.println(BONUS_NUMBER_MESSAGE);
            userInput = Console.readLine().trim();
        } while (false);
        return Integer.parseInt(userInput.trim());
    }
}
