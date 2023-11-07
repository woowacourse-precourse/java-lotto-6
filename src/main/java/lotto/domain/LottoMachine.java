package lotto.domain;

import static lotto.constants.Config.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.dto.UserInputMoney;

public class LottoMachine {

    private UserInputMoney inputMoney;
    private List<Lotto> lottos = new ArrayList<>();
    public LottoMachine() {

    }

    public void generateLottos() {
        checkMoney();
        long lottoCount = inputMoney.amount() / LOTTO_PRICE;
        this.lottos = Lotto.createLottos(lottoCount);
    }

    private void checkMoney() {
        if (inputMoney == null || inputMoney.isLessThan(LOTTO_PRICE)) {
            throw new IllegalStateException();
        }
    }

    public void insertMoney(String readLine) {
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

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
