package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.configuration.BonusCount;
import lotto.configuration.WinningLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final String COMMAS = ",";
    private static final Integer START_NUMBER = 1;
    private static final Integer LAST_NUMBER = 45;
    private static final Integer COUNT = 6;

    public List<Integer> convertToLottoIntegerList(String userInput) {
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> generateRandomLottoNumbers(Integer length) {

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (Integer count = 0; count < length; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, COUNT);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public Integer countMatchingWinningNumbers(List<Integer> winningLotto, List<Integer> myLotto) {

        Integer countValue = 0;

        for (int j = 0; j < COUNT; j++) {
            if (winningLotto.contains(myLotto.get(j))) {
                countValue++;
            }
        }

        return countValue;
    }

    public void repeatCompare() {

        Lotto lotto = new Lotto(convertToLottoIntegerList("1,2,3,4,5,6"));
        List<Integer> winningLotto = lotto.getLotto();
        List<List<Integer>> myLotto = generateRandomLottoNumbers(8);

        for (int i = 0; i < 8; i++) {
            countMatchingWinningNumbers(winningLotto, myLotto.get(i));
        }
    }

    public Integer countMatchingBonusNumbers(List<Integer> winningLotto) {
        BonusNumber bonusNumber = new BonusNumber(5);
        if (winningLotto.contains(bonusNumber)) {
            return BonusCount.PLUS_ONE.getWeight();
        }
        return BonusCount.PLUS_ZERO.getWeight();
    }
}
