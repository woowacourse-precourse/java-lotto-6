package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.domain.lotto.LottoAmount;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.lotto.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String NUMBERS_DELIMITER = ",";
    public static final String NEW_LINE = "\n";

    private InputView() {
    }

    public static LottoAmount inputAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = toInteger(Console.readLine());

            return new LottoAmount(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputAmount();
        }
    }

    public static WinningLotto inputWinningLotto() {
        try {
            LottoNumbers numbers = inputWinningNumbers();
            LottoNumber bonus = inputBonusNumber();

            return new WinningLotto(numbers, bonus);
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return inputWinningLotto();
        }
    }

    private static LottoNumbers inputWinningNumbers() {
        try {
            System.out.println(NEW_LINE + "당첨 번호를 입력해 주세요.");
            String read = Console.readLine();
            List<LottoNumber> lottoNumbers = Arrays.stream(read.split(NUMBERS_DELIMITER))
                    .map(String::trim)
                    .map(InputView::toInteger)
                    .map(LottoNumber::from)
                    .toList();

            return new LottoNumbers(lottoNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
    }

    private static LottoNumber inputBonusNumber() {
        try {
            System.out.println(NEW_LINE + "보너스 번호를 입력해 주세요.");
            int bonus = toInteger(Console.readLine());

            return LottoNumber.from(bonus);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber();
        }
    }

    private static int toInteger(String read) {
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.message());
        }
    }
}