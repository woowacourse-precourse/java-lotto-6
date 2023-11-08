package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPublisher {
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_NUMBER_LOTTO = 1;
    public static final int MAX_NUMBER_LOTTO = 45;
    public static final int COUNT_OF_LOTTO = 6;

    public int validationPrice(String inputPrice) {
        int price = 0;

        Error.CHECK.isAllInteger(inputPrice);
        price = Integer.parseInt(inputPrice);
        Error.CHECK.isUnder1000Price(price);

        return price;
    }

    public int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoCount > 0) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO, MAX_NUMBER_LOTTO, COUNT_OF_LOTTO);
            List<Integer> lotto = new ArrayList<>(randomNumber);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
            lottoCount--;
        }
        return lottos;
    }

    public List<Integer> validationWinNumber(String[] inputNumbers) {
        Error.CHECK.isAllInteger(inputNumbers);
        List<Integer> winnerNumbers = arrayToList(stringArrayToInteger(inputNumbers));
        Error.CHECK.isCollect6Number(winnerNumbers);
        Error.CHECK.isRange45(winnerNumbers);
        Error.CHECK.isDuplicate(winnerNumbers);
        return winnerNumbers;
    }

    public int[] stringArrayToInteger(String[] array) {
        return Stream.of(array).mapToInt(Integer::parseInt).toArray();
    }

    public List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public int validationBonusNumber(Lotto number, String input) {
        Error.CHECK.isAllInteger(input);
        int bonusNumber = Integer.parseInt(input);
        Error.CHECK.isDuplicate(number, bonusNumber);
        Error.CHECK.isRange45(List.of(bonusNumber));
        return bonusNumber;
    }

}
