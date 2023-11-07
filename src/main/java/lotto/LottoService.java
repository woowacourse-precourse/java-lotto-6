package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static lotto.LottoDetailNumberConstant.*;

public class LottoService {
    private static final String BUY_MONEY_UNIT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 1000원 단위의 금액을 입력해야 합니다.";
    private static final String BUY_MONEY_RANGE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 0원 보다 큰 숫자를 입력해야 합니다.";
    private static final String BUY_MONEY_TYPE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 자연수를 입력해야 합니다.";
    private static final String INPUT_NUMBER_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 숫자를 입력해야 합니다.";
    private static final String INPUT_PLAYER_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 1 ~ 45의 자연수를 입력해야 합니다.";
    private static final String INPUT_PLAYER_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE = "[ERROR] 당첨번호는 6자리를 입력해야 합니다.";
    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호와 다른 보너스 번호를 입력해야 합니다.";
    private static final Pattern NUMBER_MATCH = Pattern.compile("^[0-9]*$");
    private final List<List<Integer>> lottoNumberStore = new ArrayList<>();
    private final List<Integer> winningNumberStore = new ArrayList<>();
    private final Player player = new Player();
    private final LottoMatchCount lottoMatchCount = new LottoMatchCount();
    private final LottoResultStore lottoResultStore = new LottoResultStore();
    private Lotto lotto;

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

    public List<Integer> createWinningNumber(String inputWinningNumber) {
        String[] winningNumber = inputWinningNumber.split(",");
        validateWinningNumberSize(winningNumber);
        for (String number : winningNumber) {
            validateWinningNumber(number);
            winningNumberStore.add(toInt(number));
        }
        return winningNumberStore;
    }

    public void settingWinningNumber(List<Integer> inputWinningNumber) {
        lotto = new Lotto(inputWinningNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int createBonusNumber(String inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        return toInt(inputBonusNumber);
    }

    public void settingBonusNumber(int inputBonusNumber) {
        player.settingBonusNumber(inputBonusNumber);
    }

    public void playerNumberCompareLottoNumber() {
        for (List<Integer> lottoNumber : lottoNumberStore) {
            for (int winningNumber : lotto.getNumbers()) {
                compareWinningNumberMatch(winningNumber, lottoNumber);
            }
            compareBonusNumberMatch(player.getBonusNumber(), lottoNumber);
            checkLottoRank(lottoMatchCount.getWinningNumberMatch(), lottoMatchCount.getBonusNumberMatch());
            lottoMatchCount.resetCount();
        }
    }

    public void resetLottoResultStore() {
        lottoResultStore.resetLottoResultStore();
    }

    private void compareWinningNumberMatch(int winningNumber, List<Integer> lottoNumber) {
        if (lottoNumber.contains(winningNumber))
            lottoMatchCount.plusWinningMatchCount();
    }

    private void compareBonusNumberMatch(int bonusNumber, List<Integer> lottoNumber) {
        if (lottoNumber.contains(bonusNumber))
            lottoMatchCount.plusBonusMatchCount();
    }

    private void checkLottoRank(int winningNumberMatch, int bonusNumberMatch) {
        lottoResultStore.checkLottoRank(winningNumberMatch, bonusNumberMatch);
    }

    public Map<Integer, Integer> getLottoResultStore() {
        return lottoResultStore.getLottoResultStore();
    }

    public int totalRewardMoney() {
        int totalRewardMoney = ZERO;
        for (int reward : getLottoResultStore().keySet()) {
            totalRewardMoney += reward * getLottoResultStore().get(reward);
        }
        return totalRewardMoney;
    }

    public double getTotalRewardResult() {
        double totalReturn = (double) totalRewardMoney() / player.getBuyMoney();
        return Math.round(totalReturn) / 10.0;
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

    public void validateBonusNumber(String inputBonusNumber) {
        validateInputNumberBlank(inputBonusNumber);
        validateInputPlayerLottoNumberRange(toInt(inputBonusNumber));
        validateWinningNumberDuplicateBonusNumber(lotto.getNumbers(), inputBonusNumber);
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

    private void validateWinningNumberSize(String[] inputWinningNumber) {
        if (inputWinningNumber.length != LOTTO_NUMBER_STORE_SIZE)
            throw new IllegalArgumentException(INPUT_PLAYER_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE);
    }

    private void validateWinningNumberDuplicateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.stream().anyMatch(winningNumber -> winningNumber == toInt(bonusNumber)))
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
    }

    private int toInt(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }
}
