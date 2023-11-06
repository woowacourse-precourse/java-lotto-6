package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class Communicator {
    private static final Reader DEFAULT_READER = new ConsoleReader();
    private static final Printer DEFAULT_PRINTER = new ConsolePrinter();

    private final Reader reader;
    private final Printer printer;

    public Communicator() {
        this(DEFAULT_READER, DEFAULT_PRINTER);
    }

    public Communicator(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public BigDecimal instructBuy() {
        BigDecimal payment = getMoneyWithPrompt("구입금액을 입력해주세요.");
        validatePositive(payment);
        validateDivisible(payment);
        return payment;
    }

    public String instructJackpotNumbers() {
        return getStringWithPrompt("당첨 번호를 입력해주세요.");
    }

    public String instructBonusNumber() {
        return getStringWithPrompt("보너스 번호를 입력해 주세요.");
    }

    public void printException(RuntimeException exception) {
        printer.print(exception.getMessage());
    }

    public void printLotteriesBought(List<Lotto> lotteries) {
        int numberOfLotteries = lotteries.size();
        printer.print("%s개를 구매했습니다.".formatted(numberOfLotteries));
        lotteries.forEach(this::printLotto);
    }

    private BigDecimal getMoneyWithPrompt(String prompt) {
        printer.print(prompt);
        return getNonNullMoney();
    }

    private String getStringWithPrompt(String prompt) {
        printer.print(prompt);
        return reader.readLine();
    }

    private BigDecimal getNonNullMoney() {
        try {
            return reader.readMoney();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException("입력 금액이 비어 있습니다.");
        }
    }

    private void validateDivisible(BigDecimal payment) {
        BigDecimal remainder = payment.remainder(new BigDecimal(1000));
        if (remainder.compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validatePositive(BigDecimal payment) {
        if (payment.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("0보다 큰 금액을 입력해주세요.");
        }
    }

    private void printLotto(Lotto lotto) {
        printer.print(lotto.toTextFormat());
    }
}
