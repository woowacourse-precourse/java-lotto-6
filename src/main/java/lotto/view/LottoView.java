package lotto.view;

import static lotto.constant.Message.BONUS_NUMBER_PROMPT;
import static lotto.constant.Message.PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;
import static lotto.constant.Message.RETURN_RATE_MESSAGE;
import static lotto.constant.Message.WINNING_CASE_MESSAGE;
import static lotto.constant.Message.WINNING_NUMBER_PROMPT;

import camp.nextstep.edu.missionutils.Console;
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
    public void println(String string) {
        System.out.println(string);
    }

    @Override
    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    @Override
    public void printMessage(Message message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }

    @Override
    public String askPurchaseAmount() {
        printMessage(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }

    @Override
    public void printPurchaseQuantity(LottoPurchaseDto lottoPurchaseDto) {
        printMessage(PURCHASE_AMOUNT_MESSAGE, lottoPurchaseDto.quantity());
    }

    @Override
    public void printLottoNumbers(LottosDto lottosDto) {
        lottosDto.lottos()
                .forEach(lottoDto ->
                        println(lottoDto.getLottoNumbers())
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
    public void printWinningCase(WinningResultDto winningResultDto) {
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
    public void printReturnRateMessage(ReturnRateDto returnRateDto) {
        printMessage(RETURN_RATE_MESSAGE, returnRateDto.returnRate());
    }
}
