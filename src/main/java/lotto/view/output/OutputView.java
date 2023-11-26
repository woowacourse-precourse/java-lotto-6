package lotto.view.output;

import static lotto.view.output.message.OutputMessage.PRINT_ANALYSIS_FORMAT;
import static lotto.view.output.message.OutputMessage.PRINT_PURCHASED_LOTTOS_MESSAGE;

import java.util.List;
import lotto.dto.AnalysisDto;
import lotto.dto.LottosDto;
import lotto.view.output.message.OutputMessage;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final OutputMessage outputMessage) {
        this.printMessage(outputMessage.getMessage());
    }

    public void printReadAmountMessage() {
        printMessage(OutputMessage.READ_AMOUNT_MESSAGE);
    }

    public void printPurchasedLottosMessage(final List<LottosDto> lottosStatus) {
        printEmptyLine();
        final int count = lottosStatus.size();
        final String message = String.format(PRINT_PURCHASED_LOTTOS_MESSAGE.getMessage(), count);
        printMessage(message);
    }

    public void printLottosStatus(final List<LottosDto> lottosStatus) {
        lottosStatus.stream()
                .map(LottosDto::toString)
                .forEach(this::printMessage);
    }

    public void printReadWinningLottoMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_WINNING_NUMBER_MESSAGE);
    }

    public void printReadBonusNumberMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_BONUS_NUMBER_MESSAGE);
    }

    public void printAnalysis(final AnalysisDto analysisDto) {
        printEmptyLine();
        printMessage(String.format(PRINT_ANALYSIS_FORMAT.getMessage(),
                analysisDto.threeMatched(),
                analysisDto.fourMatched(),
                analysisDto.fiveMatched(),
                analysisDto.fiveMatchedWithBonus(),
                analysisDto.sixMatched(),
                analysisDto.profitRate()));
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
