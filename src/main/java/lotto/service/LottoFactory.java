package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class LottoFactory {

    public UserLotto createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return new UserLotto(lottos);
    }

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public Lotto makeWinningLotto(String winningLotto) {
        List<Integer> numbers = new ArrayList<>();
        try {
            makeStringToList(winningLotto).forEach(s -> numbers.add(Integer.parseInt(s.trim())));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        validate(numbers);
        sort(numbers);
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
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
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
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        return bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLottoNumber, int bonusNumber) {
        validateLottoNumber(bonusNumber);
        validateDuplicateBonusNumber(winningLottoNumber, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto winningLottoNumber, int bonusNumber) {
        if(winningLottoNumber.isContain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이미 당첨 번호에 포함된 숫자입니다.");
        }
    }

    private void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    public WinningLotto makeWinningLottoWithBonusNumber(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
