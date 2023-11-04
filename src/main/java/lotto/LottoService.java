package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoService {
    public Money changeStringToInt(String str) {
        try{
            return new Money(Integer.parseInt(str));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
    }

    public int calculateCount(int money){
        return money/1000;
    }

    public static HashMap<Integer, Lotto> makeLotto(int count){
        HashMap<Integer, Lotto> lotties = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(makeRandomNumber());
            lotties.put(i, lotto);
        }
        return lotties;
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45,6);
        Collections.sort(numbers);
        return numbers;
    }
}
