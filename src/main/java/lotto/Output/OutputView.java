package lotto.Output;

import java.util.List;

public class OutputView {
    private static final String purchaseMessage = "구입금액을 입력해주세요.";
    private static final String countMessage = "개를 구매했습니다.";
    private static final String answerMessage = "\n당첨 번호를 입력해 주세요.";
    private static final String bounsMessage = "\n보너스 번호를 입력해 주세요.";
    private static final String answerResultMessage  = "\n당첨 통계\n---";
    private static final List<String> correctMessage = List.of("3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - ");

    private static final String returnRateMessage = "총 수익률은 ";
    public static void printLottoAmount(){
        System.out.println(purchaseMessage);
    }
    public static void printLottoCount(int lottoCount){
        String lottoCountMessage = lottoCount + countMessage;
        System.out.println('\n'+lottoCountMessage);
    }

    public static void printUserLotto(List<Integer> userLotto){
        System.out.println(userLotto);
    }

    public static void printAnswerMessage(){
        System.out.println(answerMessage);
    }

    public static void printBonusMessage(){
        System.out.println(bounsMessage);
    }

    public static void printCorrectMessage(List<Integer> userLottosResult){
        System.out.println(answerResultMessage);
        for (int i = 0; i < userLottosResult.size(); i++) {
            String combined = correctMessage.get(i) + userLottosResult.get(i) + "개";
            System.out.println(combined);
        }
    }

    public static void printReturnRateMessage(double returnRate){
        System.out.println(returnRateMessage + (100+returnRate) + "%입니다.");
    }
}
