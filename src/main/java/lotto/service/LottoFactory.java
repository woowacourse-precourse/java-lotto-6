package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException.LottoNumberDuplicateException;
import lotto.exception.LottoException.LottoNumberFormatException;
import lotto.exception.LottoException.LottoNumberRangeException;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class LottoFactory {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public UserLotto createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return new UserLotto(lottos);
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }

    public WinningLotto makeWinningLottoWithBonusNumber(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Lotto makeWinningLotto(String winningLotto) {
        List<Integer> numbers = new ArrayList<>();
        try {
            makeStringToList(winningLotto).forEach(s -> numbers.add(Integer.parseInt(s.trim())));
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException();
        }
        validate(numbers);
        return new Lotto(numbers);
    }

    private List<String> makeStringToList(String inputString) {
        String[] split = inputString.split(",");
        return Arrays.stream(split).toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new LottoNumberDuplicateException();
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumber);
    }

    public int makeBonusNumber(Lotto winningLottoNumber, String inputBonusNumber) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
            validateBonusNumber(winningLottoNumber, bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException();
        }
        return bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLottoNumber, int bonusNumber) {
        validateLottoNumber(bonusNumber);
        validateDuplicateBonusNumber(winningLottoNumber, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto winningLottoNumber, int bonusNumber) {
        if(winningLottoNumber.isContain(bonusNumber)) {
            throw new LottoNumberDuplicateException();
        }
    }

    private void validateLottoNumber(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new LottoNumberRangeException();
        }
    }
}
