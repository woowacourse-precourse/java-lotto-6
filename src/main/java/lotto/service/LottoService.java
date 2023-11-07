package lotto.service;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.utils.InputUtil;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;
import lotto.view.InputView;

public class LottoService {

    public Buyer purchaseLotto() {
        try {
            InputView.inputPrise();
            return new Buyer(lottoPayment());
        } catch (IllegalArgumentException e) {
            return purchaseLotto();
        }
    }

    public WinningLotto initWinningLotto() {
        List<Integer> correctNumbers = inputWinningLotto();
        return inputBonusNumberAndGenerateWinningLotto(correctNumbers);
    }

    public Rank getRankCode(Lotto lotto, WinningLotto winningLotto) {
        int cnt = LottoUtils.matchLotto(lotto.getNumbers(), winningLotto.getNumbers());
        boolean bonusMatch = LottoUtils.matchBonus(cnt, lotto, winningLotto.getBonus());
        return Rank.getPrize(cnt, bonusMatch);
    }

    private List<Integer> inputWinningLotto() {
        try {
            InputView.inputNumbers();
            List<Integer> integers = LottoUtils.stringToList(InputUtil.inputStringWithTrim());
            return new Lotto(integers).getNumbers();
        } catch (IllegalArgumentException e) {
            return inputWinningLotto();
        }
    }

    private WinningLotto inputBonusNumberAndGenerateWinningLotto(List<Integer> numbers) {
        try {
            InputView.inputBonusNumber();
            return new WinningLotto(numbers, InputUtil.inputStringWithTrim());
        } catch (IllegalArgumentException e) {
            return inputBonusNumberAndGenerateWinningLotto(numbers);
        }
    }

    private Long lottoPayment() {
        return Long.parseLong(amountValidation(InputUtil.inputStringWithTrim()));
    }

    private String amountValidation(String amount) {
        validateNumber(amount);
        Validation.checkIsDivideByThousand(amount);
        return amount;
    }

    private void validateNumber(String num) {
        Validation.checkIsNumber(num);
        Validation.checkIsNatural(Integer.parseInt(num));
    }

}
