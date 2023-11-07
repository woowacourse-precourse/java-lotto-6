package domain;

import constant.LottoConfig;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    final List<Lotto> lottos;
    public Lottos(int issueCount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<issueCount; i++){
            lottos.add(createLotto());
        }

        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private Lotto createLotto(){
        List<Integer> notDuplecateNumbers = RandomNumberGenerator.create(
                LottoConfig.NUM_COUNT.getValue(),
                LottoConfig.START_INCLUSIVE.getValue(),
                LottoConfig.END_INCLUSIVE.getValue()
        );
        return new Lotto(notDuplecateNumbers);
    }
}
