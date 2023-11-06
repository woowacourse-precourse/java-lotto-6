package lotto.view;

import lotto.constant.Format;
import lotto.io.InputStream;
import lotto.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int inputMoney() throws IllegalArgumentException {
        int money = inputStream.inputInt();
        Validator.checkPositive(money);
        Validator.checkThousandDivision(money);
        return money;
    }

    public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        String inputLine = inputStream.inputLine();
        List<String> elements = List.of(inputLine.split(Format.DELIMITER.get()));
        List<Integer> winningNumbers = new ArrayList<>();
        for (String element : elements) {
            int number = Validator.checkLottoNumberInput(element);
            Validator.checkDuplicated(winningNumbers, number);
            winningNumbers.add(number);
        }
        Validator.checkLottoNumbersCount(winningNumbers);
        Validator.checkDelimiterCount(inputLine);
        return winningNumbers;
    }

    public int inputBonusNumber() {
        int number = inputStream.inputInt();
        return Validator.checkLottoRange(number);
    }
}