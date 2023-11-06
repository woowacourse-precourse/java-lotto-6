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

    @Override
    public Money readUserPurchaseMoney() {
        String purchaseMoney = readLine().trim();
        if(isNumeric(purchaseMoney)) {
            return new Money(Integer.parseInt(purchaseMoney));
        }

        throw new IllegalArgumentException("구입 금액은 숫자로 입력해주세요.");
    }

    @Override
    public List<LottoNumber> readWinnerLottoNumbers() throws IllegalArgumentException {
        List<LottoNumber> lottoNumbers = Arrays.stream(readLine().trim().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        if(!isValidWinningNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개의 중복없는 숫자로 이루어져야 합니다.");
        }

        return lottoNumbers;
    }

    @Override
    public LottoNumber readBonusNumber() {
        String input = readLine().trim();
        if(isNumeric(input)) {
            return new LottoNumber(Integer.parseInt(input));
        }

        throw new IllegalArgumentException("보너스 번호는 숫자로 입력해주세요.");
    }
}
