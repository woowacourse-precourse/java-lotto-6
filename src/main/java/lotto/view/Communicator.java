package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import lotto.domain.Lotto;
import lotto.domain.result.LottoResults;
import lotto.io.printer.Printer;
import lotto.io.printer.PrinterFactory;
import lotto.io.reader.Reader;
import lotto.io.reader.ReaderFactory;

public class Communicator {
    private static final BigDecimal PRICE_PER_LOTTO = new BigDecimal(1000);
    private static final int DIVISIBLE = 0;
    private static final int GREATER_FLAG = 1;

    private final Reader reader;
    private final Printer printer;

    public Communicator() {
        this(ReaderFactory.getReader(), PrinterFactory.getPrinter());
    }

    private Communicator(Reader reader, Printer printer) {
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
        printer.print("[ERROR] %s".formatted(exception.getMessage()));
    }

    public void printLotteriesBought(List<Lotto> lotteries) {
        int numberOfLotteries = lotteries.size();
        printer.print("%s개를 구매했습니다.".formatted(numberOfLotteries));
        lotteries.forEach(this::printLotto);
    }

    public void printResults(BigDecimal payment, LottoResults results) {
        printer.print("당첨 통계");
        printer.print(results.toTextFormat());
        printProfitRate(payment, results);
    }

    private void printLotto(Lotto lotto) {
        printer.print(lotto.toTextFormat());
    }

    private void printProfitRate(BigDecimal payment, LottoResults results) {
        String profitRate = results.calculateProfitRate(payment)
                .toString();
        printer.print("총 수익률은 %s%%입니다.".formatted(profitRate));
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
        BigDecimal remainder = payment.remainder(PRICE_PER_LOTTO);
        if (remainder.compareTo(BigDecimal.ZERO) != DIVISIBLE) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validatePositive(BigDecimal payment) {
        if (payment.compareTo(BigDecimal.ZERO) < GREATER_FLAG) {
            throw new IllegalArgumentException("0보다 큰 금액을 입력해주세요.");
        }
    }
}
