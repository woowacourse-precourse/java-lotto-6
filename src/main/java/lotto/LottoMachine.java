package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    // 기본 생성자
    public LottoMachine() {
    }

    // 1~45 사이의 중복없는 무작위 로또 번호 반환하는 메서드
    public List<Integer> getRandomLottoNumbers() {

        List<Integer> LottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return LottoNumbers;
    }

}



