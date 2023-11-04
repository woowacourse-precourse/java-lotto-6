package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private int numberOfTheLotto;
    private NumberUtil numberUtil;
    private List<Lotto> lottos;

    public Lottos(int numberOfTheLotto, NumberUtil numberUtil) {
        this.numberOfTheLotto = numberOfTheLotto;
        this.numberUtil = numberUtil;
        this.lottos = new ArrayList<>();
        //TODO: lotto 생성 메서드 생성
    }

    public List<Lotto> generateLottos() {
        for(int i = 0; i< numberOfTheLotto; i++) {
            List<Integer> lottoNumbers = numberUtil.generateNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }


}
