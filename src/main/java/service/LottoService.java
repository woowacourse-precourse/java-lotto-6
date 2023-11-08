package service;

import common.Constant;
import common.LottoNumberGenerator;
import dto.Purchase;
import model.Amount;
import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private int count = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private static LottoService instance = new LottoService();
    private LottoService(){}

    public static LottoService getInstance(){
        return instance;
    }

    public Purchase start(Amount amount){
        count = divideAmount(amount.getAmount());
        for(int i = 0; i<count; i++){
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumber());
            lottos.add(lotto);
        }
        return new Purchase(lottos, count);
    }

    private int divideAmount(int amount){
        return amount / Constant.DIVIDE_UNIT;
    }

}
