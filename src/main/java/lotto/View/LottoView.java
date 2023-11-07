package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    private int price;
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonus;
    public void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void setPrice() {
        this.price = Integer.parseInt(Console.readLine());
    }

    public int getPrice() {
        return price;
    }

    public void printNumOfLotto(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(List<Integer> lotto) {
        Collections.sort(lotto);
        System.out.println(lotto);
    }

    public void printWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumber = (Arrays.asList(Console.readLine().split(","))).stream().map(Integer::parseInt
        ).collect(Collectors.toList());
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void printBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
    }

    public int getBonus(){
        return bonus;
    }

    public void enter() {
        System.out.println();
    }
}
