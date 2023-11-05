package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputViewImpl implements InputView {

    @Override
    public Money readUserPurchaseMoney() {
        String purchaseMoney = readLine();
        return new Money(Long.parseLong(purchaseMoney));
    }

    @Override
    public List<LottoNumber> readWinnerLottoNumbers() {
        return Arrays.stream(readLine().trim().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public LottoNumber readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine().trim());
        return new LottoNumber(bonusNumber);
    }
}
