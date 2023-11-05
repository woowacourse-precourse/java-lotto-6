package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.Lottos;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoList {

    public List<Lotto> createLottoList(int ticket){
        List<Lotto> lottoList = new ArrayList<>();
        for ( int i = 0 ; i < ticket ; i++ ){
            lottoList.add(createLotto());
        }

        return lottoList;
    }

    public Lotto createLotto(){
        CreateLotto lotto = new CreateLotto();
        return lotto.createLotto();
    }

}
