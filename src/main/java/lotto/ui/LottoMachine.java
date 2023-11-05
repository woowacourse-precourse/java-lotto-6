package lotto.ui;

import static lotto.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.Lotto;
import lotto.WinningNumber;
import lotto.ui.reader.InputReader;

public class LottoMachine {

    private UserInputMoney inputMoney;
    private final InputReader inputReader;

    public LottoMachine(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public WinningNumber inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String readLine = inputReader.readInput();
        List<Integer> parsingNumbers = parseToIntegerList(readLine);
        WinningNumber winningNumber = new WinningNumber(parsingNumbers);
        System.out.println();

        return winningNumber;
    }

    private List<Integer> parseToIntegerList(String readLine) {
        List<String> parsedString = List.of(readLine.split(","));
        List<Integer> parsingNumbers = getIntegerList(parsedString);
        return parsingNumbers;
    }

    private List<Integer> getIntegerList(List<String> parsedString) {
        List<Integer> parsingNumbers = new ArrayList<>();
        for (String str : parsedString) {
            try {
                parsingNumbers.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("");
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("");
            }
        }
        return parsingNumbers;
    }

    public List<Lotto> generateLottos() {
        checkMoney();
        int lottoCount = inputMoney.amount() / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> newLottos = Lotto.createLottos(lottoCount);
        newLottos.forEach(System.out::println);
        return newLottos;
    }

    private void checkMoney() {
        if (inputMoney == null || inputMoney.isLessThan(LOTTO_PRICE)) {
            throw new IllegalStateException();
        }
    }

    public void insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = inputReader.readInput();
        Integer inputAmount = validateAndConvertInt(readLine);
        this.inputMoney = new UserInputMoney(inputAmount);
    }

    private static Integer validateAndConvertInt(String inputMoney) {
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
