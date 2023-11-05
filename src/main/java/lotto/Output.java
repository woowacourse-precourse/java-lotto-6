package lotto;

public class Output {
    private final static String NUMBER = "개를 구매했습니다.";
    public void count(){
        UserInput input = new UserInput();
        int num = input.purchase() / 1000;
        System.out.println("\n"+num+NUMBER);
    }
}
