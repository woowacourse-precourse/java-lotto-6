package lotto.service;

import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.NOT_WORK_LOTTO_GENERATOR;

public class DeliverService {
    List<Lotto> lottoPackage;
    public void generateLotto(int num){
        lottoPackage = new ArrayList<>();
        LottoGenerator generator = new LottoGenerator();

        int i=0;
        while(i<num){
            Lotto lotto = null;
            try{
                lotto = new Lotto(generator.generate());
            } catch (IllegalArgumentException e){
                Output output = new Output();
                output.printError(NOT_WORK_LOTTO_GENERATOR.getMessage());
            }
            if(lotto!=null) {
                lottoPackage.add(lotto);
                i++;
            }
        }
    }

    public List<Lotto> getLottoPackage(){
        return lottoPackage;
    }

}
