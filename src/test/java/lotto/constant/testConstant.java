package lotto.constant;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;

public class testConstant {
    public static final Lotto LOTTO_1_TO_6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    public static final Lotto LOTTO_4_TO_9 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
    public static final Lotto LOTTO_7_TO_12 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
    public static final Lotto LOTTO_1_TO_5_WITH_45 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
    public static final int BONUS_NUMBER_45 = 45;
    public static final LottoCollection LOTTO_COLLECTION_1TO6_7TO12 = LottoCollection.from(
            List.of(LOTTO_1_TO_6, LOTTO_7_TO_12));
}
