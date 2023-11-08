package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.exception.Exception;
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

    public Price getPurchasePrice(){
        int price;
        while (true){
            try{
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

    private static void generateLottoTicket(List<List<Integer>> lottoNumbers){
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

    public Bonus getBonusNumber(){
        Bonus bonus;
        while (true){
            try{
                bonus = validValues.validBonus(input.getBonusNumberInput());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return bonus;
    }

}
