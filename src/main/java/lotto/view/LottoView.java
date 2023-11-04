package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public String requestInput(InputRequestMessage inputRequestMessage) {
        inputRequestMessage.println();
        return Console.readLine();
    }

    public void printError(ErrorMessage errorMessage) {
        errorMessage.println();
    }
}
