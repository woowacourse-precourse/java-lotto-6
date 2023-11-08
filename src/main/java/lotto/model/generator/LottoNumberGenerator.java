package lotto.model.generator;

import java.util.Comparator;
import java.util.List;

/**
 * 로또 번호를 생성하는 generator이다.
 */
public interface LottoNumberGenerator {
    /**
     * 로또 번호를 추첨한다.
     *
     * @param order 로또 번호 추첨 후 정렬 기준
     * @return 추첨한 로또 번호
     */
    List<Integer> drawLots(Comparator<Integer> order);
}
