package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.ErrorMessage.ISNOTINTEGER;

public class LottoNumberMaker {
    private static int buyPrice;
    private static final List<List<Integer>> numbers = new ArrayList<>();
    private static final LottoController lottoController = new LottoController();

    public static int getBuyPrice() {
        return buyPrice;
    }

    public void makeLottoNumber(Integer count) {
        buyPrice = count;
        IntStream.range(0, count / 1000)
                .forEach(i -> numbers.add(makeRandomNumber()));
    }

    private List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void checkInt() {
        while (true) {
            try {
                int number = checkCount();
                makeLottoNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ISNOTINTEGER.getMessage());
            }
        }
    }

    private int checkCount() {
        try {
            return Integer.parseInt(lottoController.askPrice());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ISNOTINTEGER.getMessage());
        }
    }

    public List<List<Integer>> getLottoNumber() {
        return numbers;
    }
}
