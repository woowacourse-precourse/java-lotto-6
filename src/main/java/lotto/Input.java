package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private int money = 0;
    private int numberOfLotto = 0;

    public int getMoney(){
        return this.money;
    }
    public int getNumberOfLotto(){
        return this.numberOfLotto;
    }
    public void setNumberOfLotto(){
        int numberOfLotto = calculate(money);
        System.out.println(numberOfLotto+"개를 구매했습니다.");
    }
    public void setMoney(){
        try{
            System.out.println("구입금액을 입력해 주세요.\n");
            String input = Console.readLine();
            this.money = Integer.parseInt(input);
            validateMoney(money);
        } catch (NumberFormatException error){
            System.out.println(ERROR_MESSAGE + " 숫자를 입력해주세요.");
        }
    }

    private void validateMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE+" 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }


    private int calculate(int money){
        return money / 1000;
    }

    public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }
}
