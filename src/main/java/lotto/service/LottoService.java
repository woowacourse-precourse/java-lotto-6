package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    //모델을 수정하는 곳
    //lotto 자체 관련 로직

    public int convertToTimes(String inputMoney) {
        int money = validateMoney(inputMoney);
        if (money % 1000 == 0 )
            return money / 1000;
        throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }


    public static int validateMoney(String inputMoney){
        String REGEX = "[0-9]+";
        if(!inputMoney.matches(REGEX) || inputMoney.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        return Integer.parseInt(inputMoney);
    }



    public List<Lotto> createLottoes(int times) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            result.add(createLotto());
        }
        return result;
    }


    public Lotto createLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }





}