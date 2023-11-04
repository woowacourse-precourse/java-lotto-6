package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public class LottoService {

    //모델을 수정하는 곳
    //lotto 자체 관련 로직

    public int convertToTimes(int money){
        if(money % 1000 == 0)
            return money / 1000;
        throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }

    public List<Lotto> createLottoes(int times) {
    }
}
