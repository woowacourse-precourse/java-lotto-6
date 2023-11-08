package lottoWinningNumber;

import static constant.RequestMessage.WINNING_NUMBER_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class WinningNumberInput {
    public void getWinningNumbers(String[] winningNumbersStringList, List<Integer> winningNumberList,
                                  Converter converter) {
        for (String word : winningNumbersStringList) {
            int winningNumber = converter.stringToInteger(word);
            winningNumberList.add(winningNumber);
        }
    }

    public String[] makeWinningNumberStringList(String winningNumbers, Converter converter) {
        return converter.tokenizeByComma(winningNumbers);
    }

    public String receiveWinningNumbers() {
        printWinningNumberRequestMessage();
        return Console.readLine();
    }

    private void printWinningNumberRequestMessage() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }
}