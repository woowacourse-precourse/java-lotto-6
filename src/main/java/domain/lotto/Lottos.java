package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private int lottoBuyCount;
    private NumberUtil numberUtil;
    private List<Lotto> lottos;

    public Lottos(int lottoBuyCount, NumberUtil numberUtil) {
        this.lottoBuyCount = lottoBuyCount;
        this.numberUtil = numberUtil;
        this.lottos = new ArrayList<>();
        //TODO: lotto 생성 메서드 생성
    }

    public List<Lotto> generateLottos() {
        for(int i = 0; i<lottoBuyCount; i++) {
            List<Integer> lottoNumbers = numberUtil.generateNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }


}
