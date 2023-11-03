package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<Lotto> lottoRepository = new ArrayList<>();

    public void add(Lotto lotto){
        lottoRepository.add(lotto);
    }

    public void printAllLotto(){
        lottoRepository.forEach(Lotto::printLottoInfo);
    }

}
