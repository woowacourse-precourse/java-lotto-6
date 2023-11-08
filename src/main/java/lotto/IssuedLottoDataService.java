package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssuedLottoDataService {
    InputView inputView = new InputView();
    public IssuedLottos create_issued_lottos(){
        int amount = purchaceAmount()/1000;
        IssuedLottos issuedLottos = new IssuedLottos(new ArrayList<>(), amount);
        for(int i = 0 ; i < amount ; i++){
            IssuedLotto issuedLotto = create_issued_lotto_Numbers();
            issuedLottos.add(issuedLotto);
        }
        return issuedLottos;
    }
    private int purchaceAmount(){
        String money = inputView.InputpurchaseAmount();
        Validation.validateNumberType(money);
        return Integer.parseInt(money);
    }

    private IssuedLotto create_issued_lotto_Numbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lotto_numbers = new ArrayList<>(numbers);
        Collections.sort(lotto_numbers);
        return new IssuedLotto(lotto_numbers);
    }
}
