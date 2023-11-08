package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.util.LottoGenerator;
import lotto.util.LottoUtil;

import java.util.function.Function;
import java.util.function.Supplier;

public class InputView {

    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static <T> T getInput(Supplier<String> messageSupplier, Function<String, T> inputProcessor) {
        while (true) {
            try {
                System.out.println(messageSupplier.get());
                String input = Console.readLine();
                return inputProcessor.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningLotto getWinningLottoNumbers() {
        Lotto winningLotto = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningLotto);

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public static Price getPurchasePrice() {
        return getInput(
                () -> PURCHASE_PRICE_INPUT_MESSAGE,
                input -> new Price(LottoUtil.parseInteger(input))
        );
    }

    public static Lotto getValidatedWinningNumbers() {
        return getInput(
                () -> WINNING_NUMBERS_INPUT_MESSAGE,
                LottoGenerator::generateWinningLottoNumbers
        );
    }

    public static int getValidatedBonusNumber(Lotto winningLotto) {
        return getInput(
                () -> BONUS_NUMBER_INPUT_MESSAGE,
                input -> LottoUtil.parseLottoBonusNumber(input, winningLotto)
        );
    }

}
