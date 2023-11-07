package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;

public class LottoGameUtil {
    public static int StringToInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> stringArrayToList(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).boxed().toList();
    }
    
    public static Lotties setLotties(int count) {
        List<Lotto> lottoSaver = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers();
            Collections.sort(randomNumbers);
            lottoSaver.add(new Lotto(randomNumbers));
        }

        return new Lotties(lottoSaver);
    }
}
