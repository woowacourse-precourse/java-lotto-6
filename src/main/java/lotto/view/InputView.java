package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.utils.StringUtils;
import lotto.validation.ViewValidation;

public class InputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER_COMMA = ",";

    public LottoMoney printMoney() {
        while (true) {
            try {
                System.out.println(INPUT_MONEY);
                String money = Console.readLine();
                ViewValidation.validateNumeric(money);
                return new LottoMoney(Integer.parseInt(money));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Lotto printWiningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINING_NUMBERS);
                String numbers = Console.readLine();
                ViewValidation.validateCommaNumeric(numbers);
                return new Lotto(StringUtils.asListByDelimiter(numbers, DELIMITER_COMMA));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Bonus printBonusNumber() {
        while (true) {
            try {
                System.out.println(NEW_LINE + INPUT_BONUS_NUMBER);
                String number = Console.readLine();
                ViewValidation.validateNumeric(number);
                return new Bonus(Integer.parseInt(number));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
