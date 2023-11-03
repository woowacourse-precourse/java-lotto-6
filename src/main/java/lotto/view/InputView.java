package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Messages;
import lotto.utils.Printer;
import lotto.utils.Reader;

public class InputView {
    private final Printer printer;
    private final Reader reader;

    public InputView(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public String readMoney(){
        printer.print(Messages.REQUEST_MONEY.toString());
        return Console.readLine();
    }
}
