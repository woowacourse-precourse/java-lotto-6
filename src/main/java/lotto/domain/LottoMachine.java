package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_SIZE;
import static lotto.domain.constant.LottoConstant.MAX_RANGE;
import static lotto.domain.constant.LottoConstant.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoMachineValidationHandler;
import lotto.domain.validation.LottoValidationHandler;
import lotto.util.StringUtils;

public class LottoMachine {
    private List<Integer> winningNumbers;

    public List<Lotto> generateLottos(int purchaseLottoCount) {
        validationLottoCount(purchaseLottoCount);
        final List<Lotto> lottos = new ArrayList<>();
        for(int count = 0; count < purchaseLottoCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }

        return Collections.unmodifiableList(lottos);
    }

    private void validationLottoCount(int purchaseLottoCount) {
        LottoMachineValidationHandler.validationMinGenerateLottoCount(purchaseLottoCount);
    }

    public List<Integer> registerWinningNumber(String winningNumber) {
        List<String> convertedWinningNumbers = getWinningNumberListString(winningNumber);
        this.winningNumbers = getWinningNumbersListInteger(convertedWinningNumbers);

        return Collections.unmodifiableList(this.winningNumbers);
    }

    private List<Integer> getWinningNumbersListInteger(List<String> winningNumbers) {
        List<Integer> convertedWinningNumbers = StringUtils.convertStringListToIntegerList(winningNumbers);
        validationWinningNumbers(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    private List<String> getWinningNumberListString(String winningNumber) {
        List<String> convertedWinningNumbers = StringUtils.splitCommaToListString(winningNumber);
        LottoMachineValidationHandler.validationAllNumeric(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    private void validationWinningNumbers(List<Integer> winningNumbers) {
        LottoValidationHandler.validationNumbersSize(winningNumbers);
        LottoValidationHandler.validateDuplicatedNumbers(winningNumbers);
        LottoValidationHandler.validationNumbersRange(winningNumbers);
    }
}
