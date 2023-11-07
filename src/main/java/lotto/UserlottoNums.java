package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class UserlottoNums {
    private ArrayList<Lotto> userLottos = new ArrayList<Lotto>();

    public UserlottoNums(int numberLottoCreations){
        for(int i = 0; i<numberLottoCreations; i++){
            userLottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Integer> getlottoNum(int index){
        return userLottos.get(index).getNumbers();
    }
}