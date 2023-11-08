package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import static lotto.Constants.*;
import java.util.*;

public class Util {
    public static Lotto toLotto(String inputWinningNum){
        String[] winningNumArray = inputWinningNum.split(Constants.SEPARATOR);
        List<Integer> winningNumList = new ArrayList<>();

        for(String s : winningNumArray) {
            int toIntValue = Integer.parseInt(s);
            if(winningNumList.contains(toIntValue)){
                throw new IllegalArgumentException();
            }
            winningNumList.add(toIntValue);
        }
        return new Lotto(winningNumList);
    }

    public static List<Integer> getRandomNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Numbers.ONE.getValue(), END_NUMBER, Numbers.SIX.getValue());
        List<Integer> noDuplication = new ArrayList<>(numbers.stream().distinct().toList());

        while(noDuplication.size() != Numbers.SIX.getValue()){
            noDuplication.add(Randoms.pickNumberInRange(Numbers.ONE.getValue(), END_NUMBER));
            noDuplication = new ArrayList<>(noDuplication.stream().distinct().toList());
        }
        return noDuplication;
    }

    public static List<Integer> sortLottoNumbers(List<Integer> lottoNum) {
      Collections.sort(lottoNum);
      return lottoNum;
    }
}
