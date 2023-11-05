package lotto.scenario;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoResult;
import lotto.util.ErrorHandler;
import lotto.util.LoggingErrorHandler;
import lotto.util.NumberScanner;

public class LottoScenario implements Scenario {
    public static final String MESSAGE_ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final ErrorHandler errorHandler = new LoggingErrorHandler();
    private final NumberScanner scanner = new NumberScanner();

    private final Customer customer = new Customer();
    private final LottoMachine machine = new LottoMachine();
    private Lotto winning;
    private LottoMatcher matcher;

    public void play() {
        List<Scenario> scenarios = List.of(this::purchaseLottos,
                this::getWinningNumbers,
                this::getBonusNumber,
                this::printResult);

        scenarios.forEach(scenario -> scenario.playUntilSuccess(errorHandler));
    }

    public void purchaseLottos() {
        System.out.println(MESSAGE_ASK_PURCHASE_MONEY);
        int money = scanner.scanSingleInteger();

        customer.setMoney(money);
        customer.purchaseLotto(machine);

        System.out.println();
        customer.printPurchasedLottos();

        System.out.println();
    }

    public void getWinningNumbers() {
        System.out.println(MESSAGE_ASK_WINNING_NUMBERS);
        List<Integer> numbers = scanner.scanCommaSeperatedIntegers();
        winning = new Lotto(numbers);

        System.out.println();
    }

    public void getBonusNumber() {
        System.out.println(MESSAGE_ASK_BONUS_NUMBER);
        int bonusNumber = scanner.scanSingleInteger();
        matcher = new LottoMatcher(winning, bonusNumber);

        System.out.println();
    }

    public void printResult() {
        LottoResult result = matcher.matchAll(customer.getPurchasedLottos());
        System.out.println(result.getReport());
    }
}
