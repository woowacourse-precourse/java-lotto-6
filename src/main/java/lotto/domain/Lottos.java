package lotto.domain;

import lotto.Validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lottos {
    private Validator validator= new Validator();
    public static final int NUMBER_MIN =1;
    public static final int NUMBER_MAX =45;
    public static final int NUMBER_QUANTITY =6;

    public List<Integer>numbers;
    public List<Lotto> purchasedLottos = new ArrayList<>();
    public Lottos(){

    }

    public void createLotto() {
        createRandomNumber();

        Lotto lotto=new Lotto(numbers);
        purchasedLottos.add(lotto);
    }

    public void createRandomNumber() {
     numbers= pickUniqueNumbersInRange(NUMBER_MIN,NUMBER_MAX,NUMBER_QUANTITY);
    }


}
