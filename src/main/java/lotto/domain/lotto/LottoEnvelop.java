package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoEnvelop {
    // TODO: 11/6/23 상수 관리 
    private static final String NEW_LINE = "\n";
    private List<Lotto> lottoEnvelop;

    public LottoEnvelop() {
        lottoEnvelop = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoEnvelop.add(lotto);
    }

    public Integer size() {
        return lottoEnvelop.size();
    }

    public StringBuilder giveInformation() {
        int sizeLottoEnvelop = lottoEnvelop.size();

        StringBuilder information = getInformationEnvelop(sizeLottoEnvelop);

        return information;
    }

    private StringBuilder getInformationEnvelop(int sizeLottoEnvelop) {
        Lotto lotto;
        StringBuilder lottoInformation;
        StringBuilder information = new StringBuilder();

        for (int i = 0; i < sizeLottoEnvelop; i++) {
            lotto = getLotto(i);
            lottoInformation = getLottoInformation(lotto);
            appendLottoInformation(lottoInformation, information);
        }

        return information;
    }

    private StringBuilder getLottoInformation(Lotto lotto) {
        return lotto.giveInformation();
    }

    private void appendLottoInformation(StringBuilder lottoInformation, StringBuilder information) {
        information.append(lottoInformation + NEW_LINE);
    }

    private Lotto getLotto(int index) {
        return lottoEnvelop.get(index);
    }

    public Lotto takeLotto(Integer index) {
        return this.lottoEnvelop.get(index);
    }
}
