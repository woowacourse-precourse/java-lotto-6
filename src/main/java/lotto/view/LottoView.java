package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;
import lotto.constant.LottoMessage;

public class LottoView {

    public void readPurchaseAmount() {
        write(LottoMessage.getPurchaseAmountInputMessage());
    }

    private void write(String output) {
        System.out.println(output);
    }

    private String read() {
        return Console.readLine();
    }

    private <T> T readUntilValidInput(Function<String, T> mapper) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = mapper.apply(read());
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                write(e.getMessage());
            }
        }

        return input;
    }
}
