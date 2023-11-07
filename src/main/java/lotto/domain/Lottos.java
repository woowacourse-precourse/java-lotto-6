package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;
    private static int LOTTO_SIZE = 6;

    public Lottos(int numberOfLotto){
        lottos = new ArrayList<>();
        createLottos(numberOfLotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void createLottos(Integer numberOfLotto){
        for(int i=0;i<numberOfLotto;i++){
            List<Integer> oneLotto = createLotto();
            checkLottoNumberInBound(oneLotto);
            lottos.add(new Lotto(oneLotto));
        }
    }

    private List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, LOTTO_SIZE);
    }

    private void checkLottoNumberInBound(List<Integer> oneLotto){
        for (int oneLottoNumber : oneLotto) {
            if (oneLottoNumber < START_NUMBER || oneLottoNumber > LAST_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
