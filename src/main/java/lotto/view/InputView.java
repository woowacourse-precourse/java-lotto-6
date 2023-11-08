package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ConvertorUtil;
import lotto.validator.BonusNumberValidator;
import lotto.validator.BuyAmountValidator;
import lotto.validator.LottoValidator;

import java.util.List;

import static lotto.constants.InputMessages.*;

public class InputView {
    public BuyAmountValidator readBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT.getMessage());
        return new BuyAmountValidator(Console.readLine());
    }

    public List<Integer> readWinNumber() {
        System.out.println(INPUT_WIN_NUMBER.getMessage());
        return new LottoValidator(ConvertorUtil.convertToList(Console.readLine()))
                .numbers()
                .stream()
                .map(Integer::valueOf)
                .toList();
    }

    public Integer readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(
                new BonusNumberValidator(Console.readLine().trim())
                        .number());
    }
}
