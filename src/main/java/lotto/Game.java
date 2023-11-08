package lotto;

import static lotto.Constants.*;
import static lotto.ResultCase.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private BuyingPrice buyingPrice;
    private List<Lotto> lottos;
    private Winning winning;
    private Bonus bonus;
    private Result result;

    public Game() {
        this.buyingPrice = new BuyingPrice();
        this.lottos = new ArrayList<>();
        this.winning = new Winning();
        this.bonus = new Bonus();
        this.result = new Result();
    }

    public void run() {
        printInformBuyingPrice();
        saveBuyingPrice();
        printBuyingCount();
        giveLotto();
        printLotto();
        printInformWinningNumber();
        saveWinningNumber();
        printInformBonusNumber();
        saveBonusNumber();
        countWinning();
        printWinning();
        printRateOfReturn();
    }

    private void printInformBuyingPrice() {
        System.out.println(BUYING_PRICE);
    }

    private void saveBuyingPrice() {
        saveValue(buyingPrice);
    }

    private void printBuyingCount() {
        buyingPrice.printCount();
    }

    private void giveLotto() {
        for (int i = 0; i < buyingPrice.getBuyingCount(); i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
            lottos.add(new Lotto(uniqueNumbers));
        }
    }

    private void printLotto() {
        for(Lotto lotto : lottos) {
            ArrayList<Integer> copyNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(copyNumbers);
            String result = copyNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(LOTTO_PRINT_DELIMITER, LOTTO_PRINT_START, LOTTO_PRINT_END));
            System.out.println(result);
        }
    }

    private void printInformWinningNumber() {
        inform(WINNING_NUMBER);
    }

    private void saveWinningNumber() {
        saveValue(winning);
    }

    private void printInformBonusNumber() {
        inform(BONUS_NUMBER);
    }

    private void saveBonusNumber() {
        bonus.setWinningNumbers(winning.getNumbers());
        saveValue(bonus);
    }

    private void countWinning() {
        for (ResultCase resultCase : ResultCase.values()) {
            result.save(resultCase, count(resultCase));
        }
    }

    private Integer count(ResultCase resultCase) {
        Integer matchLotto = ZERO;
        for (Lotto lotto : lottos) {
            int equalNumbers = lotto.count(winning.getNumbers());
            if (resultCase == FIVE_AND_BONUS_CORRECTNESS && equalNumbers == resultCase.getCorrectness()) {
                matchLotto = addBonus(lotto, matchLotto);
                continue;
            }
            if (resultCase != FIVE_AND_BONUS_CORRECTNESS && equalNumbers == resultCase.getCorrectness()) {
                matchLotto++;
            }
        }
        return matchLotto;
    }

    private Integer addBonus(Lotto lotto, Integer matchLotto) {
        if(guessBonus(lotto)) {
            matchLotto++;
        }
        return matchLotto;
    }

    private Boolean guessBonus(Lotto lotto) {
        if (lotto.contain(bonus.getNumber())) {
            return true;
        }
        return false;
    }

    private void printWinning() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        result.print();
    }

    private void printRateOfReturn() {
        System.out.print(RATE_OF_RETURN + calculateRateOfReturn() + PERCENT_IS);
    }

    private Double calculateRateOfReturn() {
        return result.getCalculateRateOfReturn(buyingPrice.getPrice());
    }

    private void inform(String comment) {
        System.out.println();
        System.out.println(comment);
    }

    private void saveValue(Input input) {
        Boolean isNotEnded = true;
        while (isNotEnded) {
            try {
                String readLine = Console.readLine();
                input.save(readLine);
                isNotEnded = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
