package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.RankOfLotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class View {

    public int buyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        try{
            stringToList(money);
            return Integer.parseInt(money);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
        return buyMoney();
    }
    public int buyLotto(int buyMoney){
        return buyMoney / 1000;
    }
    private void stringToList(String money){
        if(!isValidString(money)){
            throw new IllegalArgumentException("로또 구입 금액은 숫자로 이루어져야 합니다.");
        }
        if(!isDivideNumber(money)){
            throw new IllegalArgumentException(" 로또 구입 금액은 천원단위로 나눠져야 합니다.");
        }
    }
    private boolean isValidString(String money){
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, money);
    }
    private boolean isDivideNumber(String money){
        if(Integer.parseInt(money) % 1000 != 0){
            return false;
        }
        return true;
    }
    public List<Integer> correctNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    public String bonusNum(List correctLotto){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        try{
            bonusNumException(correctLotto, bonus);
            return bonus;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
        return bonusNum(correctLotto);
    }

    public static void lottoResult(List countRank, int myMoney){
        float percentLotto;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(RankOfLotto.FIFTH.printRank + Collections.frequency(countRank, 3) +"개");
        System.out.println(RankOfLotto.FOURTH.printRank + Collections.frequency(countRank, 4) +"개");
        System.out.println(RankOfLotto.THIRD.printRank + Collections.frequency(countRank, 5) +"개");
        System.out.println(RankOfLotto.SECOND.printRank + Collections.frequency(countRank, 7) +"개");
        System.out.println(RankOfLotto.FIRST.printRank + Collections.frequency(countRank, 6) +"개");
        percentLotto = (Collections.frequency(countRank, 3) * 5000) +
                (Collections.frequency(countRank, 4) * 50000) +
                (Collections.frequency(countRank, 5) * 15000000) +
                (Collections.frequency(countRank, 7) * 30000000) +
                (Collections.frequency(countRank, 6) * 2000000000);

        DecimalFormat df = new DecimalFormat("#,###.#");
        float percent = (percentLotto / myMoney) * 100;
        System.out.println("총 수익률은 " + df.format(percent) + "%입니다.");
    }
    private void bonusNumException(List correctLotto, String bonus){
        if(correctLotto.contains(Integer.parseInt(bonus))){
            throw new IllegalArgumentException("로또 번호는 중복이 불가능 합니다.");
        }
        if(Integer.parseInt(bonus) > 45 || Integer.parseInt(bonus) < 1){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
