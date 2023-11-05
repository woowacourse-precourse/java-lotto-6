package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    //로또 생성을 담당하는 클래스

    public static List<Lotto> createLottos(int number){
        List<Lotto> lottos = new ArrayList<>();
        while (number > 0){
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(randomNumber);
            lottos.add(lotto);
            number--;
        }

        return lottos;
    }


}
