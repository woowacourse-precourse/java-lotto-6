package lotto;

import java.util.ArrayList;
import java.util.List;

public class View {

    private static final String INPUT_COST = "구입금액을 입력해 주세요.";
    private static final String INFO_HOW_MANY = "개를 구매했습니다.";
    private static final String INPUT_DRAW_WINNER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String DIVISION_LINE = "당첨 통계\n---";

    private static final String FIFTH = "3개 일지 (5,000원) - ";
    private static final String FOURTH = "4개 일지 (50,000원) - ";
    private static final String THIRD = "5개 일지 (1,500,000원) - ";
    private static final String SECOND = "5개 일지, 보너스 불 일치 (30,000,000원) - ";
    private static final String FIRST = "6개 일지 (2,000,000,000원) - ";
    private static final String RESULT = "총 수익률은 ";
    private static final String RESULT_TAIL = "입니다.";


    private Integer bonusNumber;


    public void printStart(){
        System.out.println(INPUT_COST);
    }

    public void printBuyInfo(Integer count, List<Lotto> list){
        System.out.println();
        System.out.println(count + INFO_HOW_MANY);
        for(Lotto lotto : list){
            System.out.println(lotto);
        }
        System.out.println();
    }

    public Lotto printInputPrizeNumber(){
        System.out.println(INPUT_DRAW_WINNER);
        Lotto drawWinner = Calculator.drawWinner();
        System.out.println();
        return drawWinner;
    }

    public Integer printRequireBonus(){
        Integer bonus;
        System.out.println(INPUT_BONUS);
        bonus = Calculator.drawBonus();
        System.out.println();
        return bonus;
    }



    public List<String> printWinnerStatistic(){
        System.out.println(DIVISION_LINE);
        List<String> rating = new ArrayList<String>();
        rating.add(FIFTH);
        rating.add(FOURTH);
        rating.add(THIRD);
        rating.add(SECOND);
        rating.add(FIRST);
        return rating;
//        System.out.println(FIVE);
//        System.out.println(FOUR);
//        System.out.println(THREE);
//        System.out.println(SECOND);
//        System.out.println(FIRST);
//        System.out.println(RESULT+231+RESULT_TAIL);

    }

    public void printMargin(Double margin){
        System.out.println(RESULT+margin+RESULT_TAIL);
    }



}
