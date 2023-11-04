package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {

    private static final int LOTTO_MINIMAL_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int COUNT_OF_UNIQUE_NUMBERS = 6;

    public LottoGame(){
    }

    public void startProcess(){
        int money = -1;
        while(money < 0){
            GuideMessage.ofInputMoney();
            money = GameInput.insertMoney();
        }
        Lotto lotto = issueLotto();
    }

    public Lotto issueLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMAL_NUMBER,
                LOTTO_MAXIMUM_NUMBER,COUNT_OF_UNIQUE_NUMBERS));
    }
}
