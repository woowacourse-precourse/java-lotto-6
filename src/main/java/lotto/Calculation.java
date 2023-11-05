package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Calculation {
    public int get_game_count(int money) {
        if(money/1000 == 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력하세요."); 
        }
        return money/1000;
    }

    public List<Integer> generate_lotto() {
        List<Integer> lotto_number = new ArrayList<>();
        
        lotto_number = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(lotto_number);
        return lotto_number;
    }
}
