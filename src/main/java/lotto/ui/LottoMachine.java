package lotto.ui;

import static lotto.Lotto.LOTTO_PRICE;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.Lotto;
import lotto.ui.reader.InputReader;

public class LottoMachine {

    private UserInputMoney inputMoney;
    private final InputReader inputReader;

    public LottoMachine(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public List<Lotto> generateLottos() {
        checkMoney();
        long lottoCount = inputMoney.amount() / LOTTO_PRICE;
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
        Long inputAmount = validateAndConvertInt(readLine);
        this.inputMoney = new UserInputMoney(inputAmount);
    }

    private static Long validateAndConvertInt(String inputMoney) {
        Long inputAmount;
        try {
            inputAmount = Long.parseLong(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
        return inputAmount;
    }

    public long getInputAmount() {
        return inputMoney.getAmount();
    }
}
