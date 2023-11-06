package Output;

import lotto.BuyLotto;
import lotto.Lotto;

import java.util.List;

public class Output {
    private static BuyLotto buylotto = new BuyLotto();

    public void buyMoneyAsk() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyNumberPaperAns(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void answerNumberAsk() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberAsk() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void correctStatisPrint() {
        System.out.println("당첨 통계");
        System.out.println("---");
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
