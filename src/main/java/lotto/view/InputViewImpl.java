package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.InputValidator.isNumeric;
import static lotto.util.InputValidator.isValidWinningNumbers;

public class InputViewImpl implements InputView {

    private static final String INPUT_PURCHASE_ERROR_MESSAGE = "구입 금액은 숫자로 입력해주세요.";
    private static final String INPUT_WINNER_NUMBERS_ERROR_MESSAGE = "당첨 번호는 6개의 중복없는 숫자로 이루어져야 합니다.";
    private static final String INPUT_BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 숫자로 입력해주세요.";

    @Override
    public Money readUserPurchaseMoney() {
        String purchaseMoney = readLine().trim();
        if(isNumeric(purchaseMoney)) {
            return new Money(Integer.parseInt(purchaseMoney));
        }

        throw new IllegalArgumentException(INPUT_PURCHASE_ERROR_MESSAGE);
    }

    @Override
    public List<LottoNumber> readWinnerLottoNumbers() throws IllegalArgumentException {
        List<LottoNumber> lottoNumbers = Arrays.stream(readLine().trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        if(!isValidWinningNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(INPUT_WINNER_NUMBERS_ERROR_MESSAGE);
        }

        return lottoNumbers;
    }

    @Override
    public LottoNumber readBonusNumber() {
        String input = readLine().trim();
        if(isNumeric(input)) {
            return new LottoNumber(Integer.parseInt(input));
        }

        throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR_MESSAGE);
    }
}
