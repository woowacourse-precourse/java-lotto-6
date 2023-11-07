package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputInitializer {

    public int inputtingPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        new PurchaseAmountValidator().validate(moneyInput);
        return Integer.parseInt(moneyInput) / 1000;
    }

    public Lotto inputtingLottoNumber() {
        System.out.println("당첨 번호 입력해 주세요.");
        String lottoNumbersInput = Console.readLine();
        new LottoNumberValidator().validate(lottoNumbersInput);
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
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        new BonusNumberValidator().validate(bonusNumberInput, lotto);
        return Integer.parseInt(bonusNumberInput);
    }
}
