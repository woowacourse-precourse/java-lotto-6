package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<List<Integer>> userLottoNumbers = new ArrayList<>();
    private int bonusNumber = 0;
    private int amount = 0;
    private List<Integer> result;
    static final int START = 1;
    static final int END = 45;
    static final int SIZE=6;
    static final int ONE_FOR_PRICE=1000;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static int getOneForPrice() {
        return ONE_FOR_PRICE;
    }

    public List<List<Integer>> getUserLottoNumbers() {
        return this.userLottoNumbers;
    }

    public List<Integer> initMatchResult() {
        List<Integer> matchResult = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            matchResult.add(0);
        }
        return matchResult;
    }

    public int countMatchResult(List<Integer> numbers, List<Integer> lottoNumber) {
        int checkCount = 0;
        for (int number : lottoNumber) {
            if (numbers.contains(number)) {
                checkCount += 1;
            }
        }
        return checkCount;
    }
}
