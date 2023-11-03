package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakeLottoNumbersService {

    private static String PURCHASE_NUMBER_PRINT = "%d개를 구매했습니다.";

    public List<HashSet<Integer>> makeLottoNumbers(Integer lottoCount){
        List<HashSet<Integer>> lottoNumbersArray = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbersArray.add(new HashSet<>(numbers));
        }
        return lottoNumbersArray;
    }

    public void printLottoNumberArrays(List<HashSet<Integer>> lottoNumbersArray){
        System.out.println(PURCHASE_NUMBER_PRINT.formatted(lottoNumbersArray.size()));
        for (HashSet<Integer> oneArray : lottoNumbersArray) {
            System.out.println(oneArray.stream().sorted().toList());
        }
    }

}
