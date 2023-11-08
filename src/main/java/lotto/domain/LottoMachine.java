package lotto.domain;

import static lotto.constants.Config.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.constants.Message;
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
            throw new IllegalStateException(Message.NO_MONEY_TO_BUY_LOTTO);
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
            throw new IllegalArgumentException(Message.INPUT_NOT_NUMBER_EXCEPTION);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Message.INPUT_NULL_EXCEPTION);
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
