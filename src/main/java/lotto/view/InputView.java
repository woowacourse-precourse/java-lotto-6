package lotto.view;

import lotto.constant.Format;
import lotto.io.InputStream;
import lotto.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
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
            winningNumbers.add(Validator.checkLottoNumber(element));
        }
        Validator.checkLottoNumbersCount(winningNumbers);
        Validator.checkDelimiterCount(inputLine);
        return winningNumbers;
    }
}