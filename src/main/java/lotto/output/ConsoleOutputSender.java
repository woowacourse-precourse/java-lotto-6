package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;

public class ConsoleOutputSender implements OutputSender {
    public static final String EMPTY_STRING = "";
    private final OutputFormatter outputFormatter;

    public ConsoleOutputSender(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }


    @Override
    public void send(String output) {
        System.out.println(output);
    }

    @Override
    public void outputPurchaseMoneyInputMessage() {
        send(outputFormatter.formatPurchaseMoneyInputMessage());
    }

    @Override
    public void outputWinningNumberInputMessage() {
        send(outputFormatter.formatWinningNumberInputMessage());
    }

    @Override
    public void outputBonusNumberInputMessage() {
        send(outputFormatter.formatBonusNumberInputMessage());
    }

    @Override
    public void outputWinningInformation(WinningInformation winningInformation) {
        send(outputFormatter.formatWinningInformation(winningInformation));
    }

    @Override
    public void outputNewLine() {
        send(EMPTY_STRING);
    }

    @Override
    public void outputNumberOfLottos(int numberOfLottos) {
        send(outputFormatter.formatNumberOfLottos(numberOfLottos));
    }

    @Override
    public void outputLotto(Lotto lotto) {
        send(outputFormatter.formatLotto(lotto));
    }

    @Override
    public void outputError(String errorMessage) {
        send(outputFormatter.formatError(errorMessage));
    }


}
