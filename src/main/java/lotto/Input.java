package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private int totalPrice;
    private String winningNumber;
    private int bonusNumber;


    private void setTotalPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        this.totalPrice = Integer.parseInt(Console.readLine());

        if (totalPrice % 1000 != 0) {
            System.out.println("[ERROR] 로또 금액을 잘못 입력하였습니다..");
            throw new IllegalArgumentException();
        }
    }

    private void setWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        this.winningNumber = Console.readLine();
    }

    private void setBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
