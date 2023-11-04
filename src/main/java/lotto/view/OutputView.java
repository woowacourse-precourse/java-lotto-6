package lotto.view;

import java.util.List;
import lotto.constant.PrintMessage;

public class OutputView {
    public void printPaymentRequest() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
    }

    public void printAmmountLotto(int ammount) {
        System.out.printf("\n%d%s\n", ammount, PrintMessage.AMOUT_LOTTO.getMessage());
    }
    
    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

}
