package lotto.model;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class LottoNumber {
    private List<Integer> lottoNumbers;
    public LottoNumber(){
        this.generateLottoNumbers();
    }
    private void generateLottoNumbers(){
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45, 6);
    }
    public List<Integer> createWinningNumber(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
    public List<Integer> getLottoNumbers(){
        return this.lottoNumbers;
    }
}
