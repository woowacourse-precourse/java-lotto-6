package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List <Lotto> lottos;
    private int numberOfLotto;

    public LottoMachine(int numberOfLotto){
        this.numberOfLotto = numberOfLotto;
        printLottos();
        show();
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }
    private void printLottos(){
        this.lottos = new ArrayList<>();

        for(int i=0;i<numberOfLotto;i++){
            List<Integer> pickNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(pickNumber);
            lottos.add(lotto);
        }
    }

    public void show(){
        for(Lotto lotto: this.lottos){
            System.out.println(lotto.toString());
        }
    }
}
