package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.ValidValues;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private final Input input;
    private final ValidValues validValues;

    public Controller(Input input, ValidValues validValues) {
        this.input = input;
        this.validValues = validValues;
    }

    //여기에서는 output에 넣을 것들 반환해주기
    // 로또 구매 컨트롤러

    public Price getPurchasePrice() {
        int price;
        while (true) {
            try {
                price = validValues.validPurchase(input.getPurchaseInput());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return new Price(price);
    }

    //호출
    public static List<List<Integer>> generateLottoTickets(int price) {
        int count = price / 1000;
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            generateLottoTicket(lottoTickets);
        }
        return lottoTickets;
    }

    private static void generateLottoTicket(List<List<Integer>> lottoNumbers) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        lottoNumbers.add(numbers);
    }


    // 로또 당첨 번호 컨트롤러 호출하기
    public Lotto winningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            try {
                winningNumbers = validValues.validLotto(input.getLottoInput());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return new Lotto(winningNumbers);
    }

    //

    public Bonus getBonusNumber() {
        Bonus bonus;
        while (true) {
            try {
                bonus = validValues.validBonus(input.getBonusNumberInput());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return bonus;
    }

    public List<Integer> judge(List<Integer> winning, int bonusAnswer, List<List<Integer>> lottoNumbers) {
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            counts.add(0);
        }
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int count = countWinning(winning, lottoNumbers.get(i));
            boolean bonus = countBonus(bonusAnswer,lottoNumbers.get(i));
            counts = getCounts(count, counts, bonus);
        }
        return counts;
    }

    public List<Integer> getCounts(int count, List<Integer> counts, boolean bonus) {
        List<Integer> answer = counts;
        if (count == 3) {
            counts.set(0, counts.get(0) + 1);
        }
        if (count == 4) {
            counts.set(0, counts.get(1) + 1);
        }
        if (count == 5 && !bonus) {
            counts.set(0, counts.get(2) + 1);
        }
        if (count == 5 && bonus) {
            counts.set(0, counts.get(3) + 1);
        }
        if (count == 6) {
            counts.set(0, counts.get(4) + 1);
        }
        return answer;
    }

    public int countWinning(List<Integer> winning, List<Integer> input) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (winning.contains(input.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean countBonus(int bonus, List<Integer> input) {
        boolean count = false;
        if (input.contains(bonus)) {
            count = true;
        }
        return count;
    }

}
