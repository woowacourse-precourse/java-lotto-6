package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    public static Integer winStatics(ArrayList<List<Integer>> papers , List<Integer> winNum, Integer Bonus){
        Integer sumWin = 0;
        int winBonus = 0;
        int[] winPapers = {0,0,0,0,0,0,0};
        int[] winPrize = {0,0,0,5000,50000,1500000,2000000000};

        for(int i = 0; i<papers.size();i++){
            int winCount = 0;
            for(int j = 0; j<6; j++){
                if(papers.get(i).get(j) == winNum.get(j)){
                    winCount++;
                }
                if(papers.get(i).get(j) == Bonus){
                    winBonus++;
                }
            }
            winPapers[winCount]++;
        }

        for(int r = 3;r< winPapers.length;r++) {
            System.out.println(String.format("%d개 일치 (%d원) - %d", r, winPrize[r], winPapers[r]*winPrize[r]));
            sumWin += winPapers[r] * winPrize[r];
        }

        return sumWin;
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String cost = readLine();
        costValidate(cost);

        int paper = Integer.parseInt(cost)/1000;
        System.out.println(String.format("\n%d개를 구매했습니다.",paper));

        ArrayList<List<Integer>> papers = new ArrayList<>();
        for(int i=0;i<paper;i++ ){
            List<Integer> tmp = lottoGenerater();
            System.out.println(tmp);
            papers.add(tmp);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");

        List<String> winNumStr = new ArrayList<>(List.of(readLine().split(",")));
        List<Integer> winNum = new ArrayList<>();
        for(int i=0;i<winNumStr.size();i++){
            winNum.add(Integer.parseInt(winNumStr.get(i)));
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonus = Integer.parseInt(readLine());

        System.out.println("\n당첨 통계\n---");
        Integer sumWin = winStatics(papers,winNum,bonus);

        System.out.println(String.format("총 수익률은 %d%%입니다",sumWin/Integer.parseInt(cost)*100));


    }
}
