package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.config.LottoConfig.lottoPrice;
import static lotto.message.InputMessage.*;

public class InputInitializer {
    PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    String input;

    public int inputPurchaseAmount() {
        while (true) {
            System.out.println(INPUT_PURCHASE_MONEY.getMessage());
            input = Console.readLine();
            try {
                purchaseAmountValidator.validate(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return Integer.parseInt(input) / lottoPrice;
    }

    public Lotto inputLottoNumber() {
        while (true) {
            System.out.println(INPUT_WINNING_LOTTO_NUMBER.getMessage());
            input = Console.readLine();
            try {
                lottoNumberValidator.validate(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        List<Integer> lottoNumbers = lottoNumberToList(input);
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
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            input = Console.readLine();

            try {
                bonusNumberValidator.validate(input, lotto);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return Integer.parseInt(input);
    }
}
