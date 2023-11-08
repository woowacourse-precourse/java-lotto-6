package lotto.view;

import static lotto.constant.Message.BONUS_NUMBER_PROMPT;
import static lotto.constant.Message.PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;
import static lotto.constant.Message.RETURN_RATE_MESSAGE;
import static lotto.constant.Message.WINNING_CASE_MESSAGE;
import static lotto.constant.Message.WINNING_NUMBER_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import lotto.constant.Message;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.dto.ReturnRateDto;
import lotto.dto.WinningResultDto;

public class LottoView implements View {
    private LottoView() {
    }

    public static LottoView create() {
        return new LottoView();
    }

    @Override
    public void println(final String string) {
        Objects.requireNonNull(string);
        System.out.println(string);
    }

    @Override
    public void printMessage(final Message message) {
        Objects.requireNonNull(message);
        System.out.println(message.getMessage());
    }

    @Override
    public void printMessage(final Message message, final Object... args) {
        Objects.requireNonNull(message);
        Objects.requireNonNull(args);
        System.out.printf(message.getMessage(), args);
    }

    @Override
    public String askPurchaseAmount() {
        printMessage(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public void printPurchaseQuantity(final LottoPurchaseDto lottoPurchaseDto) {
        Objects.requireNonNull(lottoPurchaseDto);
        printMessage(PURCHASE_AMOUNT_MESSAGE, lottoPurchaseDto.quantity());
    }

    @Override
    public void printLottoNumbers(final LottosDto lottosDto) {
        Objects.requireNonNull(lottosDto);
        lottosDto.lottos()
                .forEach(lottoDto ->
                        println(lottoDto.toString())
                );
    }

    @Override
    public String askWinningNumber() {
        printMessage(WINNING_NUMBER_PROMPT);
        return Console.readLine();
    }

    @Override
    public String askBonusNumber() {
        printMessage(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }

    @Override
    public void printWinningResult(final WinningResultDto winningResultDto) {
        Objects.requireNonNull(winningResultDto);
        printMessage(
                WINNING_CASE_MESSAGE,
                winningResultDto.fifthPlaceCount(),
                winningResultDto.fourthPlaceCount(),
                winningResultDto.thirdPlaceCount(),
                winningResultDto.secondPlaceCount(),
                winningResultDto.firstPlaceCount()
        );
    }

    @Override
    public void printReturnRateMessage(final ReturnRateDto returnRateDto) {
        Objects.requireNonNull(returnRateDto);
        printMessage(RETURN_RATE_MESSAGE, returnRateDto.returnRate());
    }

    @Override
    public void close() {
        Console.close();
    }
}
