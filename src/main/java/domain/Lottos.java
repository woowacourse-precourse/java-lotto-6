package domain;

import constant.ConfigNumber;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    final List<Lotto> lottos;
    public Lottos(long issueCount){
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
                ConfigNumber.NUM_COUNT.getValue(),
                ConfigNumber.START_INCLUSIVE.getValue(),
                ConfigNumber.END_INCLUSIVE.getValue()
        );
        return new Lotto(notDuplecateNumbers);
    }
}
