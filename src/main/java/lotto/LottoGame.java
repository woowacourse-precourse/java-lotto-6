package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private int gameCount;
    private List<List<Integer>> lottogame;

    public void setLottoGame(int number){
        this.gameCount = number;
    }

    public void validatePurchaseAmount(int price){
        if (price % LOTTO_PRICE == 0){
            setLottoGame(price / LOTTO_PRICE);
        } else {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    public void generateLottoNumbers() {
        this.lottogame = new ArrayList<>();
        for (int i = 0; i < this.gameCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_COUNT);
            Collections.sort(numbers);
            lottogame.add(numbers);
        }
        printLotto();
    }

    public void printLotto() {
        for (List<Integer> numbers : this.lottogame){
            System.out.println(numbers.toString());
        }
    }

}
