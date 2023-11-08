package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;
import lotto.entity.LottoResult;
import lotto.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT_NUMBER = 6;

    public List<Lotto> buyLotto(Integer money) {
        int lottoCount = money / 1000;
        List<Lotto> boughtLotto = new ArrayList<>();
        while (lottoCount > 0){
            boughtLotto.add(new Lotto(getRandomLottoNumbers()));
            lottoCount--;
        }
        return boughtLotto;
    }

    public List<Integer> getRandomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
        return numbers;
    }

    public LottoResult matchResult(User user, List<Lotto> boughtLotto) {
        Integer bonusNumber = user.getBonusNumber();
        LottoResult result = matchLottoNumber(user.getInputLottoNumber(), boughtLotto, bonusNumber);

        return result;
    }

    private LottoResult matchLottoNumber(List<Integer> inputLottoNumber, List<Lotto> boughtLottos, Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto boughtLotto : boughtLottos) {
            int matchCount = getMatchCount(inputLottoNumber, boughtLotto.getNumbers());
            Boolean matched = matchBonusNumber(bonusNumber, boughtLotto.getNumbers());

            if (matchCount == 3) lottoResult.plusOne_3Correction();
            if (matchCount == 4) lottoResult.plusOne_4Correction();
            if (matchCount == 5 && matched == false) lottoResult.plusOne_5Correction();
            if (matchCount == 6) lottoResult.plusOne_6Correction();
            if (matchCount == 5 && matched == true) lottoResult.plusOne_5CorrectionAndBonus();
        }
        return lottoResult;
    }

    private Boolean matchBonusNumber(Integer bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int getMatchCount(List<Integer> inputLottoNumbers, List<Integer> lottoNumber) {
        return (int) inputLottoNumbers.stream()
                .filter(lottoNumber::contains)
                .count();
    }
}
