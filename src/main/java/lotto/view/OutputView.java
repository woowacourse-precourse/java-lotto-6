package lotto.view;

public class OutputView {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String COUNT_LOTTO = "개를 구매했습니다.";
    private final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String TOTAL = "당첨 통계\n" + "---";

    public void inputMoney(){
        System.out.println(INPUT_MONEY);
    }
}
