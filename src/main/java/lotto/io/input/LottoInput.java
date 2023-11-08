package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.data.Lotto;
import lotto.validator.LottoValidator;

public class LottoInput {
    private static final int LEFT_BOUND = 1;
    private static final int RIGHT_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String SPLIT_NUMBERS = ",";

    public static Lotto getRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LEFT_BOUND, RIGHT_BOUND, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public static List<Integer> getLottoNumbers() {
        String[] lottoNumbers = Console.readLine().split(SPLIT_NUMBERS);
        LottoValidator.validateNumbers(lottoNumbers);
        return Arrays.stream(lottoNumbers).map(Integer::parseInt).toList();
    }

    public static int getBonusLottoNumber(List<Integer> lottoNumbers) {
        String bonus = Console.readLine();
        LottoValidator.validateBonusNumber(lottoNumbers, bonus);
        return Integer.parseInt(bonus);
    }
}
