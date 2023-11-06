package lotto.Model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.View.ExceptionMessage;

public class RandomLottos {
    private static List<Integer> randomLottos;
    public static List<Integer> pickRandomNums(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoRangeStorage.MIN_NUM, LottoRangeStorage.MAX_NUM,LottoRangeStorage.LOTTO_LENGTH);
        List<Integer> mutableNumbers = new ArrayList<>(numbers); // 가변 리스트로 복사
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }

    public static  List<List<Integer>> SetRandomLottos(int ticketsAmount){
        List<List<Integer>> totalNumbers = new ArrayList<>();
        for (int i = 0 ; i < ticketsAmount; i++){
            List<Integer> randomNumbers = pickRandomNums();
            totalNumbers.add(randomNumbers);
        }
        return totalNumbers;
    }
    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
}
