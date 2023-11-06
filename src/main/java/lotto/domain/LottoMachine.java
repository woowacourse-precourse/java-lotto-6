package lotto.domain;

import static lotto.constants.LottoConfiguration.LOTTO_SIZE;
import static lotto.constants.LottoConfiguration.MAX_RANGE;
import static lotto.constants.LottoConfiguration.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    /**
     * 입력 갯수 만큼 로또 번호 생성
     *
     * @param quantity
     * @return
     */
    public List<Lotto> getPurchaseLottoes(int quantity) {
        List<Lotto> lottoes = IntStream
                .range(0, quantity)
                .mapToObj(i -> new Lotto(automaticallyGenerateLottoNumbers()))
                .collect(Collectors.toList());

        return lottoes;
    }

    /**
     * 자동 로또 번호 생성
     *
     * @return
     */
    private List<Integer> automaticallyGenerateLottoNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_RANGE.getConfig(), MAX_RANGE.getConfig(),
                LOTTO_SIZE.getConfig());

        return lottoNumbersSort(lottoNumber);
    }

    /**
     * 로또 번호 오름 차순 정렬
     *
     * @param lottoNumber
     */
    private List<Integer> lottoNumbersSort(List<Integer> lottoNumber) {
        List<Integer> sortedLottoNumber = new ArrayList<>(lottoNumber);

        Collections.sort(sortedLottoNumber); // 오름차순 정렬

        return sortedLottoNumber;
    }
}
