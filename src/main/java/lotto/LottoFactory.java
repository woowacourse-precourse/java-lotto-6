package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private int lottoNumber;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoFactory(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public void createLottos(){
        for (int i = 0; i < lottoNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        printLottos();
    }

    public void printLottos(){
        System.out.println();
        System.out.println(lottoNumber+"개를 구매했습니다.");
        for (int i = 0; i < lottoNumber; i++) {
            getLotto(i).printLotto();
        }
    }

    public Lotto getLotto(int i){
        return lottos.get(i);
    }

}
