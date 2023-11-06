package lotto.view;

public class DisplayOutput {

    private final String OUTPUTLOTTOAMOUNTOFMONEY = "구입금액을 입력해 주세요.";
    private final String OUTPUTANSWERNUMBER = "당첨 번호를 입력해 주세요.";
    private final String OUTPUTBONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public void outputLottoAmountofMoney() {
        System.out.println(OUTPUTLOTTOAMOUNTOFMONEY);
    }

    public void outputAnswerLotto() {
        System.out.println(OUTPUTANSWERNUMBER);
    }

    public void outputBonusNumber() {
        System.out.println(OUTPUTBONUSNUMBER);
    }
}
