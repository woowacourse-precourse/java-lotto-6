package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> LottosGenerator(int count){
        List<Lotto> lottos = new ArrayList<>();

        while(lottos.size() <= count){
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto(){
        return new Lotto(LottoNumberGenerator.createLottoNumber());
    }
}
