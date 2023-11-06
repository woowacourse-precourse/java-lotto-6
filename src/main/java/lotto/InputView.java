package lotto;

public class InputView {
    
    private final static String STARTMESSAGE = "구입금액을 입력해 주세요.";
    private final static String CORRECTNUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String BONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public void startMessage(){
        System.out.println(STARTMESSAGE);
    }

    public void correctNumbers(){
        System.out.println(CORRECTNUMBERS);
    }

    public void bonusNumber(){
        System.out.println(BONUSNUMBER);
    }
}
