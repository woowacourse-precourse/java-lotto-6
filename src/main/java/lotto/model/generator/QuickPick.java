package lotto.model.generator;

import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * {@code LottoNumberGenerator}의 구현부이다.
 * 로또 번호 추첨 기준 중 자동 추첨 기능을 제공한다.
 */
public class QuickPick implements LottoNumberGenerator {
    /**
     * 로또를 자동 추첨한다.
     *
     * @param order 로또 번호 추첨 후 정렬 기준
     * @return 로또 번호의 범위에 따라 로또 번호 개수만큼 생성된 정렬된 로또 번호
     */
    @Override
    public List<Integer> drawLots(Comparator<Integer> order) {
        List<Integer> immutableLottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_OF_LOTTO_NUMBER.getDetails(),
                MAXIMUM_OF_LOTTO_NUMBER.getDetails(), COUNT_OF_LOTTO_NUMBER.getDetails());

        ArrayList<Integer> lottoNumbers = new ArrayList<>(immutableLottoNumbers);

        Collections.sort(lottoNumbers, order);

        return lottoNumbers;
    }
}
