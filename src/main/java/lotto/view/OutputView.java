package lotto.view;

import java.util.List;
import lotto.constant.PrintMessage;

public class OutputView {
    public void printAmmountLotto(int ammount) {
        System.out.printf("\n%d%s\n", ammount, PrintMessage.AMOUT_LOTTO.getMessage());
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

}
