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
        IssuedLotto issuedLotto;
        int purchaseAmount = purchaceAmount();
        for(int i = 0 ; i < purchaseAmount ; i++){
            issuedLotto = create_issued_lotto_Numbers();
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
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0 ; i < 6 ; i++){
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new IssuedLotto(numbers);


    }
}
