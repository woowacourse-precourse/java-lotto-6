package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;

import lotto.domain.Client;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public void buyLotto(Client client){
        int count = client.getPurchaseAmount() / 1000;
        for(; count > 0;count--){
            Lotto lotto = generateLotto();
            client.addClientLotto(lotto);
        }
    }

    public Lotto generateLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER,LOTTO_LENGTH));
        return new Lotto(numbers);
    }

}
