package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> lottoGenerater(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Lotto lottoNum = new Lotto(numbers);
        return lottoNum.getNumbers();
    }

    public static void costValidate(String cost){
        String tmp = cost;
        if (!cost.chars().allMatch(Character::isDigit)){
            throw new NumberFormatException();
        }
        if ((Integer.parseInt(tmp) % 1000) != 0){
            throw new IllegalArgumentException();
        }
        return;

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String cost = readLine();
        costValidate(cost);

        int paper = Integer.parseInt(cost)/1000;
        ArrayList<List<Integer>> papers = new ArrayList<>();
        for(int i=0;i<paper;i++ ){
            papers.add(lottoGenerater());
        }

        System.out.println(papers.get(0));

        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winNumInput = new ArrayList<>(List.of(readLine().split(",")));

        System.out.println(winNumInput);


    }
}
