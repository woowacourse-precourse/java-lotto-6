package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static LottoMachine instance;

    private WinLotto winLotto;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (instance == null) {
            synchronized (LottoMachine.class) {
                instance = new LottoMachine();
            }
        }
        return instance;
    }

    public void setWinLotto(WinLotto winLotto) {
        this.winLotto = winLotto;
    }

    /**
     * 입력 갯수 만큼 로또 번호 생성
     *
     * @param quantity
     * @return
     */
    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        while (quantity > 0) {
            lottos.add(new Lotto(createLottoNumber()));
            quantity--;
        }

        return lottos;
    }

    /**
     * 자동 로또 번호 생성
     *
     * @return
     */
    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        lottoSort(lottoNumber);

        return lottoNumber;
    }

    /**
     * 로또 번호 오름 차순 정렬
     *
     * @param lottoNumber
     */
    private void lottoSort(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
    }

    /**
     * 로또 당첨 확인
     *
     * @param otherLotto
     * @return int
     */
    public LottoRank lottoWinningResult(Lotto otherLotto) {
        return winLotto.lottoComparison(otherLotto);
    }
}
