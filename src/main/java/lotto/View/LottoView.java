package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoView {
    private int price;
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonus;

    public void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void setPrice() {
        while (true) {
            try {
                this.price = Integer.parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입값은 정수 이어야 합니다.");
            }
        }
    }

    public int getPrice() {
        return price;
    }

    public void printNumOfLotto(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(List<Integer> lotto) {
       List<Integer> sortedLotto = new ArrayList<>(lotto);
       Collections.sort(sortedLotto);
        System.out.println(sortedLotto);
    }

    public void printWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                winningNumber = (Arrays.asList(Console.readLine().split(","))).stream().map(Integer::parseInt
                ).collect(Collectors.toList());
                Set<Integer> numSet = new HashSet<>(winningNumber);
                if (numSet.size() != winningNumber.size()) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 당첨 번호에 중복되는 숫자가 있습니다.");
            }
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void printBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 입력값은 정수 여야 합니다.");
        }

    }


    public int getBonus() {
        return bonus;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void enter() {
        System.out.println();
    }

    public void printResults(int[] rankings) {
        System.out.println("3개 일치 (5,000원) - " + rankings[3] + "개 일치");
        System.out.println("4개 일치 (50,000원) - " + rankings[4] + "개 일치");
        System.out.println("5개 일치 (1,500,000원) - " + rankings[5] + "개 일치");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankings[7] + "개 일치");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankings[6] + "개 일치");
    }

    public void printTotalIncome(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
