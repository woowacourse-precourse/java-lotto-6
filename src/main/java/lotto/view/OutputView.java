package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.utils.Printer;

public class OutputView {
    private final Printer printer;
    final private String errorPrefix = "[ERROR]";
    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printError(String errorMessage){
        printer.print(errorPrefix + errorMessage);
    }

    public void printWithArguments(String message, Object... args){
        printer.printf(message, args);
    }

    public void printLottos(List<Lotto> lottos){
        for(Lotto lotto:lottos){
            printer.print(lotto.toString());
        }
    }
}
