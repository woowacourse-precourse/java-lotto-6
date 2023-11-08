package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class UserlottoNums {
    private final ArrayList<Lotto> userLottos = new ArrayList<Lotto>();

    public UserlottoNums(int numberLottoCreations){
        for(int i = 0; i<numberLottoCreations; i++){
            userLottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Integer> getlottoNum(int index){
        if(index<0||index>userLottos.size()){
            throw new IllegalArgumentException("[ERROR] 생성한 로또 개수의 범위에 벗어 납니다.");
        }
        return userLottos.get(index).getNumbers();
    }
}