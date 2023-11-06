package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static lotto.domain.LottoPrice.*;

public class LottoResult {

    private List<LottoPrice> lottoPrices = new ArrayList<>();

    public List<LottoPrice> getLottoPrices(){
        return lottoPrices;
    }

    public void addPrice(LottoPrice lottoPrice){
        if(!lottoPrice.equals(NONE))
            lottoPrices.add(lottoPrice);
    }

    public int getPriceMoney(){
        AtomicInteger resultMoney = new AtomicInteger(0);
        lottoPrices.forEach(lottoPrice -> resultMoney.addAndGet(lottoPrice.getPriceMoney()));

        return resultMoney.get();
    }
}
