package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final NumberValidate numberValidate = new NumberValidate();

    public List<List<Integer>> generateLottoNumbers(int numberOfSheets) {
        List<List<Integer>> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfSheets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ticket);
            tickets.add(ticket);
        }

        return tickets;
    }

    public List<Integer> convertToIntegerList(String numbers) {

        List<Integer> integerList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return integerList;
    }

    public int receiveBonusNumber(String bonusNumber) {
        numberValidate.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
