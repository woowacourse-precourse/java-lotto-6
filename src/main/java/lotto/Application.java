package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(test);
        System.out.println(lotto.getNumbers());
    }

    //랜던값 만들기
    public static List<Integer>  makeRandom(){
        List<Integer> resRand = new ArrayList<>();
        while (resRand.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!resRand.contains(randomNumber)) {
                resRand.add(randomNumber);
            }
        }
        return resRand;
    }
}
