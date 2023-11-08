package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.constant;
import lotto.validation.Validation;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.IssuedLotto;
import lotto.domain.IssuedLottos;

public class IssuedLottoDataService {
    public IssuedLottos create_issued_lottos(){
        int amount = purchaceAmount()/ constant.THOUSAND;
        IssuedLottos issuedLottos = new IssuedLottos(new ArrayList<>(), amount);
        OutputView.printAmount(amount);
        for(int i = 0 ; i < amount ; i++){
            IssuedLotto issuedLotto = create_issued_lotto_Numbers();
            issuedLottos.add(issuedLotto);
        }
        return issuedLottos;
    }
    private int purchaceAmount(){
        String money;
        do {
            money = InputView.InputpurchaseAmount();
        } while (Validation.validatepurchaseAmount(money));
        return Integer.parseInt(money);
    }

    private IssuedLotto create_issued_lotto_Numbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(constant.MINLOTTONUMBER, constant.MAXLOTTONUMBER, 6);
        List<Integer> lotto_numbers = new ArrayList<>(numbers);
        Collections.sort(lotto_numbers);
        return new IssuedLotto(lotto_numbers);
    }
}
