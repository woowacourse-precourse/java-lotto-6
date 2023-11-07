package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtil {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM = 6;

    //로또 생성
    public static Lotto createLotto(){
        List<Integer> createdLotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,MAX_LOTTO_NUM,LOTTO_NUM);

        Collections.sort(createdLotto);

        return new Lotto(createdLotto);
    }

    //형태 변환
    public static List<String> converseStringToStringList(String input){
        String[] splitInput = input.split(",");
        return Arrays.asList(splitInput);
    }

    public static List<Integer> converseStringListToIntegerList(List<String> input){
        List<String> changeInput = input;
        changeInput.replaceAll(String::trim);
        return changeInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //당첨 결과 반환

    //총 수익률 반환
}
