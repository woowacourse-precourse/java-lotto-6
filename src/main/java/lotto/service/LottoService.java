package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public static Integer inputNumberOfLotto(String price) {
        return validatePrice(price) / 1000;
    }

    private static Integer validatePrice(String price) {
        try {
            int tempPrice = Integer.parseInt(price);
            if (tempPrice % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return tempPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static List<Lotto> generateLottoList(Integer numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(new Lotto(generateLotto()));
        }
        return lottoList;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    public static Lotto inputWinningNumbers() {
        Lotto winningLotto = null;

        while (winningLotto == null) {
            try {
                String input = LottoView.inputWinningNumbers();
                List<Integer> winningNumbers = parseWinningNumbers(input);
                winningLotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(s -> {
                        try {
                            return Integer.parseInt(s);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
                        }
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
