package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.validation.Validation;

public class LottoUtils {
    private static final int THIRD_OR_SECOND = 5;
    private static final String DELIMITER = ",";
    public static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.START.getValue(), LottoInfo.END.getValue(), LottoInfo.LENGTH.getValue());
    }

    public static List<Integer> sortAsc(final List<Integer> lotto) {
        return lotto.stream().sorted().toList();
    }

    public static List<Integer> stringToList(String input) {
        String[] splitInput = input.split(DELIMITER);
        Validation.checkStringConsistOfNaturalNumbers(splitInput);
        return Arrays.stream(splitInput)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public static long getLottoAmount(final Long prise) {
        return prise / LottoInfo.PRISE.getValue();
    }

    public static int matchLotto(List<Integer> buyerLotto, List<Integer> winningLotto) {
        return (int) buyerLotto.stream().filter(winningLotto::contains).count();
    }

    public static boolean matchBonus(int cnt, Lotto lotto, int bonusNumber) {
        if (cnt != THIRD_OR_SECOND) return false;
        return lotto.getNumbers().contains(bonusNumber);
    }

}
