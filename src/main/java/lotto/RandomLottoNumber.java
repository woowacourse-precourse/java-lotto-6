package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoNumber {
    public static ArrayList<List<Integer>> randLottoNumbers(int lottoChance){ // 무작위의 로또를 생성한다
        System.out.println(lottoChance + "개를 구매했습니다.");
        ArrayList<List<Integer>> randomLotto = new ArrayList<>(); // 로또 정보를 저장하기 위해 이중배열을 선언
        for(int i=0; i < lottoChance; i++){
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 1 ~ 45의 서로 다른 수를 배열에 담는다
            Lotto lotto = new Lotto(randomNumbers);
            System.out.println(lotto.LottoReturn());
            randomLotto.add(lotto.LottoReturn()); // 로또 번호를 배열에 삽입
        }
        return randomLotto;
    }
}
