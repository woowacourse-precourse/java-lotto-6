package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 랜덤 번호 6개 뽑기
    public List<Integer> randomLottoNumber(){
        List<Integer> box = new ArrayList<>();
        while(box.size() != 6) {
            int rd = Randoms.pickNumberInRange(1, 45);
            if(box.contains(rd)) continue;
            box.add(rd);
        }
        return box;
    }
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
