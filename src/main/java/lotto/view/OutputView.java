package lotto.view;
import java.util.*;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class OutputView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    private static final String USER_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WIN_NUMBER_GRAPH = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_DOUBLE_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 ";
    private static final String PERCENT = "%입니다.";

    public OutputView(){

    }

    public void purchaseComment(){
        System.out.println(PURCHASE_PRICE);
    }

    public void purchaseNumberComment(int num){
        System.out.println(num+PURCHASE_NUMBER);
    }

    public void lottoListsComment(List<List<Integer>> lottoLists){
        for(List<Integer> lottoList : lottoLists){
            System.out.println(lottoList);
        }
        System.out.println();
    }

    public void userNumberComment(){
        System.out.println(USER_NUMBER);
    }

    public void bonusNumberComment(){
        System.out.println();
        System.out.println(BONUS_NUMBER);
    }

    public void winnerGraphComment(List<Integer> correctList, double rateOfReturn){
        System.out.println();
        System.out.println(WIN_NUMBER_GRAPH);
        System.out.println(HYPHEN);
        System.out.println(THREE_CORRECT+correctList.get(0)+COUNT);
        System.out.println(FOUR_CORRECT+correctList.get(1)+COUNT);
        System.out.println(FIVE_CORRECT+correctList.get(2)+COUNT);
        System.out.println(FIVE_DOUBLE_CORRECT+correctList.get(3)+COUNT);
        System.out.println(SIX_CORRECT+correctList.get(4)+COUNT);
        System.out.println(TOTAL_RATE_OF_RETURN+rateOfReturn+PERCENT);
        System.out.println();
    }

}
