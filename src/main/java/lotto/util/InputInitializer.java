package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.message.InputMessage.*;

public class InputInitializer {

    public int inputtingPurchaseAmount() {
        PurchaseAmountValidator validator = new PurchaseAmountValidator();
        System.out.println(INPUT_PURCHASE_MONEY.getMessage());
        String moneyInput;
        boolean hasException;

        do {
            hasException = false;
            moneyInput = Console.readLine();

            try {
                validator.validate(moneyInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                hasException = true;
            }

        } while (hasException);

        return Integer.parseInt(moneyInput) / 1000;
    }

    public Lotto inputtingLottoNumber() {
        LottoNumberValidator validator = new LottoNumberValidator();
        String lottoNumbersInput;
        boolean hasException;

        do {
            hasException = false;
            System.out.println(INPUT_WINNING_LOTTO_NUMBER.getMessage());
            lottoNumbersInput = Console.readLine();

            try {
                validator.validate(lottoNumbersInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                hasException = true;
            }

        } while (hasException);

        List<Integer> lottoNumbers = lottoNumberToList(lottoNumbersInput);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> lottoNumberToList(String lottoNumbersInput) {
        List<Integer> lottoNumberList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(lottoNumbersInput, ",");

        while (tokenizer.hasMoreTokens()) {
            lottoNumberList.add(Integer.parseInt(tokenizer.nextToken()));
        }

        return lottoNumberList;
    }

    public int inputBonusNumber(Lotto lotto) {
        BonusNumberValidator validator = new BonusNumberValidator();
        String bonusNumberInput;
        boolean hasException;

        do {
            hasException = false;
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            bonusNumberInput = Console.readLine();

            try {
                validator.validate(bonusNumberInput, lotto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                hasException = true;
            }

        } while (hasException);
        return Integer.parseInt(bonusNumberInput);
    }

}
