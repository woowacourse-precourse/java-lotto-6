package lotto;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class LottoGenerator {
    LottoGenerator(){}
    public static List<Integer> getLottoNumbers (){
        List <Integer> lottoNumbers =Randoms.pickUniqueNumbersInRange(1,45,6);
        return  lottoNumbers.stream().sorted().collect(Collectors.toList());
    }
}
