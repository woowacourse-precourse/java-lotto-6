package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserLottoDataService {
    InputView inputView;
    Validation validation;

    public IssuedLottos create_issued_lottos(){
        IssuedLottos issuedLottos = new IssuedLottos(new ArrayList<>());
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
        validation.validateNumberType(money);
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
