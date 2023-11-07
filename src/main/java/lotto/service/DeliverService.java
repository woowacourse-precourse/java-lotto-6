package lotto.service;

import lotto.vo.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.NOT_WORK_LOTTO_GENERATOR;

public class DeliverService {
    public List<Lotto> generateLotto(int num){
        List<Lotto> lottoPackage = new ArrayList<>();
        LottoGenerator generator = new LottoGenerator();

        int i=0;
        while(i<num){
            Lotto lotto = new Lotto(generator.generate());
            lottoPackage.add(lotto);
            i++;
        }

        return lottoPackage;
    }

}
