package lotto.domain;

import static lotto.etc.ErrorConstant.*;
import static lotto.etc.RuleConstant.*;
import static lotto.etc.SystemConstant.THREE_ZERO;
import static lotto.etc.Validate.validateNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;
    
    // 테스트용 생성자
    public Lottos() {
        lottos = new ArrayList<>();
        int[] array1 = {8, 21, 23, 41, 42, 43};
        List<Integer> integerList = Arrays.stream(array1)
                .boxed()
                .collect(Collectors.toList());
        Collections.sort(integerList);
        lottos.add(new Lotto(integerList));
    }

    public Lottos(String timeStr) {
        lottos = new ArrayList<>();
        int timeInt = validateNumber(timeStr) / 1000;
        validate(timeStr);
        for (int i = 0; i < timeInt; i++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(START_INCLUSIVE.toInt(), END_INCLUSIVE.toInt(), COUNT.toInt());
            ArrayList<Integer> tempNumbers = new ArrayList<>(numbers);
            Collections.sort(tempNumbers);
            lottos.add(new Lotto(tempNumbers));
        }
    }

    private void validate(String time) {
        if (time.length() <= 3) {
            System.out.println(LOW_THOUSAND_ERROR);
            throw new IllegalArgumentException();
        }

        String lastThreeChars = time.substring(time.length() - 3);
        if (!lastThreeChars.equals(THREE_ZERO.toString())) {
            System.out.println(NOT_DIVIDE_THOUSAND_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
