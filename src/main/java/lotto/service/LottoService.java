package lotto.service;

import static lotto.domain.Lotto.MAX_VALUE;
import static lotto.domain.Lotto.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoFinalResult;
import lotto.domain.LottoResult;
import lotto.domain.LottoWithBonus;
import lotto.domain.UserMoney;
import lotto.repository.LottoRepository;
import lotto.util.LottoGenerator;

public class LottoService {
    public static final int STANDARD_SIZE = 6;
    private static final int SPECIAL_CASE = 5;
    private static final int SPECIAL_RESULT = 7;
    private static final int START_INCLUSIVE = 0;

    public static void generateRandomLotto(UserMoney money, LottoRepository repository) {
        int chances = money.getLottoChances();
        IntStream.range(START_INCLUSIVE, chances)
                .forEach((num) -> repository.saveLotto(
                        LottoGenerator.generateLotto(
                                () -> Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, STANDARD_SIZE))
                ));
    }

    public static LottoResult compareLottoWithBonus(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        int sameNumberCount = compareEachLotto(userLotto, generatedRandomLotto);
        if ( sameNumberCount == SPECIAL_CASE && isBonusInLotto(userLotto, generatedRandomLotto)) {
            sameNumberCount = SPECIAL_RESULT;
        }
        return LottoResult.findLottoResultBySameNumberCount(sameNumberCount);
    }

    public static float calculateRateOfReturn(LottoFinalResult lottoFinalResult, UserMoney userMoney) {
        return userMoney.calculateTotalReturn(lottoFinalResult.calculateReturn());
    }

    private static int compareEachLotto(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        return userLotto.findSameNumberCount(generatedRandomLotto);
    }

    private static boolean isBonusInLotto(LottoWithBonus userLottoWithBonus, Lotto generatedRandomLotto) {
        return userLottoWithBonus.isBonusInLotto(generatedRandomLotto);
    }
}
