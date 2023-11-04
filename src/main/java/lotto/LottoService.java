package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.LottoDetailConstant.*;

public class LottoService {
    private static final String BUY_MONEY_UNIT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 1000원 단위의 금액을 입력해야 합니다.";
    private static final String BUY_MONEY_RANGE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 0원 보다 큰 숫자를 입력해야 합니다.";
    private static final String BUY_MONEY_TYPE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 자연수를 입력해야 합니다.";
    private static final String INPUT_NUMBER_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 숫자를 입력해야 합니다.";
    private static final String INPUT_PLAYER_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 1 ~ 45의 자연수를 입력해야 합니다.";
    private static final Pattern NUMBER_MATCH = Pattern.compile("^[0-9]*$");
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final List<List<Integer>> lottoNumberStore = new ArrayList<>();
    private final Player player = new Player();

    public int calculateLottoTicket(String inputMoney) {
        validateBuyMoney(inputMoney);
        return toInt(inputMoney) / LOTTO_PRICE;
    }

    public void settingBuyMoney(int inputMoney) {
        player.settingBuyMoney(inputMoney);
    }

    public void createLottoByInputBuyMoney() {
        for (int i = 0; i < player.getBuyMoney(); i++) {
            lottoNumberStore
                    .add(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_STORE_SIZE));
        }
    }

    public List<List<Integer>> getLottoNumberStore() {
        return lottoNumberStore;
    }

    public void validateBuyMoney(String inputMoney) {
        validateInputNumberBlank(inputMoney);
        validateBuyMoneyType(inputMoney);
        validateBuyMoneyRange(inputMoney);
        validateBuyMoneyUnit(inputMoney);
    }

    public void validateWinningNumber(String inputWinningNumber) {
        validateInputNumberBlank(inputWinningNumber);
        validateInputPlayerLottoNumberRange(toInt(inputWinningNumber));
    }

    private void validateBuyMoneyType(String inputMoney) {
        if (!NUMBER_MATCH.matcher(inputMoney).matches())
            throw new IllegalArgumentException(BUY_MONEY_TYPE_EXCEPTION_MESSAGE);
    }

    private void validateBuyMoneyRange(String inputMoney) {
        if (toInt(inputMoney) == ZERO)
            throw new IllegalArgumentException(BUY_MONEY_RANGE_EXCEPTION_MESSAGE);
    }

    private void validateBuyMoneyUnit(String inputMoney) {
        if (toInt(inputMoney) % LOTTO_PRICE != ZERO)
            throw new IllegalArgumentException(BUY_MONEY_UNIT_EXCEPTION_MESSAGE);
    }

    private void validateInputNumberBlank(String inputNumber) {
        if (inputNumber.contains(" ") || inputNumber.equals(""))
            throw new IllegalArgumentException(INPUT_NUMBER_BLANK_EXCEPTION_MESSAGE);
    }

    private void validateInputPlayerLottoNumberRange(int inputLottoNumber) {
        if (!(inputLottoNumber >= LOTTO_START_NUMBER && inputLottoNumber <= LOTTO_END_NUMBER))
            throw new IllegalArgumentException(INPUT_PLAYER_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    private int toInt(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }
}
