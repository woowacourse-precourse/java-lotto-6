package lotto.ui;

import java.util.NoSuchElementException;
import lotto.ui.reader.InputReader;

public class LottoMachine {

    private UserInputMoney inputMoney;
    private final InputReader inputReader;
    public LottoMachine(InputReader inputReader) {
        this.inputReader = inputReader;
    }
    public void insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = inputReader.readInput();
        Integer inputAmount = validateAndConvert(readLine);
        this.inputMoney = new UserInputMoney(inputAmount);
    }

    private static Integer validateAndConvert(String inputMoney) {
        Integer inputAmount;
        try {
            inputAmount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
        return inputAmount;
    }
}
