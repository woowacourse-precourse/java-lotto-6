package lotto.view;

import static lotto.engine.LottoSystemConstant.LOTTO_MONEY_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MINIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_PRICE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_SEPARATOR;
import static lotto.engine.LottoSystemConstant.TextMessage.ERROR_PREFIX;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_BONUS_NUMBER;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_MONEY_FOR_BUYING_LOTTO;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_WINNING_NUMBERS_LOTTO;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.common.Message;
import lotto.common.Validator;

public class LottoGameViewer {

    private final Validator validator;
    private final LottoGameViewerMapper lottoGameViewerMapper;

    public LottoGameViewer(Validator validator, LottoGameViewerMapper lottoGameViewerMapper) {
        this.validator = validator;
        this.lottoGameViewerMapper = lottoGameViewerMapper;
    }

    public int interactForBuyLotto() {
        boolean isRetry = true;
        String money = input(INPUT_MONEY_FOR_BUYING_LOTTO);

        while (isRetry) {
            try {
                validMoney(money);
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                money = input();
            }
        }

        return lottoGameViewerMapper.toInt(money);
    }


    public List<Integer> interactForWinningNumber() {
        boolean isRetry = true;
        String winningNumbers = input(INPUT_WINNING_NUMBERS_LOTTO);

        while (isRetry) {
            try {
                validWinningNumber(winningNumbers);
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                winningNumbers = input();
            }
        }

        return lottoGameViewerMapper.toLottoNumbers(winningNumbers);
    }

    public int interactForBonusNumber() {
        boolean isRetry = true;
        String bonusNumber = input(INPUT_BONUS_NUMBER);

        while (isRetry) {
            try {
                validBonusNumber(bonusNumber);
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                bonusNumber = input();
            }
        }

        return lottoGameViewerMapper.toInt(bonusNumber);
    }

    public void println(Message message) {
        System.out.println(message.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }

    protected String input(Message message) {
        println(message);
        return Console.readLine();
    }

    protected String input() {
        return Console.readLine();
    }

    private void validMoney(String money) {
        validator.verifyNullAndBlank(money);
        validator.verifyNumber(money);
        Integer verifiedNumber = lottoGameViewerMapper.toInt(money);
        validator.verifyInRangeClosed(LOTTO_PRICE.value(), LOTTO_MONEY_MAXIMUM_VALUE.value(),
                verifiedNumber);
        validator.verifyDivisible(verifiedNumber, LOTTO_PRICE.value());
    }

    private void validBonusNumber(String bonusNumber) {
        validator.verifyNullAndBlank(bonusNumber);
        validator.verifyNumber(bonusNumber);
        Integer number = lottoGameViewerMapper.toInt(bonusNumber);
        validator.verifyInRangeClosed(
                LOTTO_NUMBER_MINIMUM_VALUE.value(),
                LOTTO_NUMBER_MAXIMUM_VALUE.value(),
                number);
    }

    private void validWinningNumber(String winningNumbers) {
        validator.verifyNullAndBlank(winningNumbers);
        List<String> numbers = lottoGameViewerMapper.toList(LOTTO_NUMBER_SEPARATOR, winningNumbers);

        if (numbers.size() != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException("유효한 길이가 아닙니다.");
        }

        numbers.forEach(validator::verifyNumber);
        numbers.stream().map(Integer::parseInt)
                .forEach(number -> validator.verifyInRangeClosed(
                        LOTTO_NUMBER_MINIMUM_VALUE.value(),
                        LOTTO_NUMBER_MAXIMUM_VALUE.value(),
                        number));
    }
}
