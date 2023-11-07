package Domain;

import Domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private int lottoCount;
    private ArrayList<Lotto> lottos = new ArrayList<Lotto>();

    public Lottos(int lottoCount) {
        this.lottoCount = lottoCount;
        System.out.println(this.lottoCount + "개를 구매했습니다.");
        makeLottoNumber();
    }

    private void makeLottoNumber() {
        while (lottos.size() < lottoCount) {
            List<Integer> numbers = new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            checkLottoNumber(numbers);
        }
    }

    private void checkLottoNumber(List<Integer> numbers){
        try{
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }catch(IllegalStateException e){}
    }

    public void showLottoNumber() {
        for(int i = 0; i < lottos.size(); i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public ArrayList<Lotto> getLottos(){
        return lottos;
    }
}
