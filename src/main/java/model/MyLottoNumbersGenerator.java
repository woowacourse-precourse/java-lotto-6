package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MyLottoNumbersGenerator {
        public List<Integer> generateMyLottoNumbers() {
                return Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
}