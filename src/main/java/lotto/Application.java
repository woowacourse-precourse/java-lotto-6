package lotto;

import lotto.controller.Comparison;
import lotto.controller.Counting;
import lotto.controller.Random;
import lotto.model.BonusNumber;
import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Random random = new Random();
        Counting counting = new Counting();

        Cash cash;
        Lotto lotto;
        BonusNumber bonusNumber;


        //구입 금액
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                cash = new Cash(input.getCash());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //구매 복권 출력
        List<List<Integer>> randomSeries = new ArrayList<>();
        System.out.printf("\n%d개를 구매했습니다.\n", cash.getNumber() / 1000);
        for (int i = 0; i < (cash.getNumber() / 1000); i++) {
            List<Integer> temp = random.makeRandom();
            randomSeries.add(temp);
            System.out.println(temp);
        }

        //당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                lotto = new Lotto(input.getWinningNums());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                bonusNumber = new BonusNumber(input.getBonusNum(), lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int[] result = new int[8]; // 결과 저장
        for (int i = 0; i < (cash.getNumber() / 1000); i++) {
            result[counting.getResult(lotto.getNumbers(), bonusNumber.getNumbers(), randomSeries.get(i))]++;
        }

        //당첨 결과
        System.out.println("\n당첨 통계\n---");
        output.showResult(result);
        output.showRevenue(result, cash.getNumber());
    }
}
