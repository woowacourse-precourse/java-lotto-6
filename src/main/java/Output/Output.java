package Output;

import Money.Winning;
import lotto.BuyLotto;
import lotto.Lotto;

import javax.swing.*;
import java.util.List;

public class Output {
    private static Winning one = Winning.one;
    private static Winning two = Winning.two;
    private static Winning three = Winning.three;
    private static Winning four = Winning.four;
    private static Winning five = Winning.five;
    private static BuyLotto buylotto = new BuyLotto();

    public void buyMoneyAsk() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyNumberPaperAns(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void answerNumberAsk() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberAsk() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void correctStatisPrint() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void StatisPrint(List<Integer> rank){
        correctStatisPrint();
        System.out.println(five.getMessage()+rank.get(0)+"개");
        System.out.println(four.getMessage()+rank.get(1)+"개");
        System.out.println(three.getMessage()+rank.get(2)+"개");
        System.out.println(two.getMessage()+rank.get(3)+"개");
        System.out.println(one.getMessage()+rank.get(4)+"개");
    }
    public String lottoBuyPaperPrint(List<Integer> paper) {
        String result = "[";
        for (int i = 0; i < paper.size(); i++) {
            if (i < paper.size() - 1) {
                result += paper.get(i) + ", ";
            }
            if (i == paper.size() - 1) {
                result += paper.get(i) + "]";
            }
        }
        return result;
    }

    public void lottoAllPaperPrint(List<Lotto> lotto) {
        for (int i = 0; i < lotto.size(); i++) {
            String paper = lottoBuyPaperPrint(lotto.get(i).getLotto());
            System.out.println(paper);
        }
    }
}
