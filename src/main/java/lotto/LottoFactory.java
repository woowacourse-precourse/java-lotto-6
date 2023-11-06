package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.Lotto.LOTTO_SIZE;

public class LottoFactory {
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private int lottoNumber;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoFactory(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public void createLottos(){
        for (int i = 0; i < lottoNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_SIZE);
            numbers.sort(Comparator.naturalOrder());
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
