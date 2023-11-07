package lotto.model;




import org.assertj.core.util.diff.myers.MyersDiff;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Set;


import static lotto.util.MagicNumbers.MIN_NUMBER;
import static lotto.util.MagicNumbers.MAX_NUMBER;
import static lotto.util.MagicNumbers.LOTTO_COUNT;


public class GenerateMyLottoNumber {
    private final List<Integer> generateMyLottoNumber;

    private GenerateMyLottoNumber(){
        this.generateMyLottoNumber = sortedRandomNumber(generateRandomNumber());
    }

    public static GenerateMyLottoNumber generateLotto(){
        return new GenerateMyLottoNumber();
    }

    private List<Integer> generateRandomNumber(){

        List<Integer> MyNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
        return MyNumbers;
    }

    private List<Integer> sortedRandomNumber(List<Integer> MyNumbers){
        Collections.sort(MyNumbers);
        return MyNumbers;
    }

}
