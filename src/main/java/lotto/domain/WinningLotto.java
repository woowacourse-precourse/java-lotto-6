package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto() {
       this.lotto = new Lotto(createWinningLottoNumber());
    }

    public Lotto getLotto() {
        return lotto;
    }


    private List<Integer> createWinningLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }








}
