package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {


    public UserInput(){
    }

    public void getPrice(){
        String input = null;
        int inputInt = 0;

        System.out.println("구입금액을 입력해 주세요.");
        input = Console.readLine();

        RandomNumberCreate randomNumberCreate = new RandomNumberCreate(validatePrice(input));
        randomNumberCreate.createRandomNumber();
        getWinningNumber();
        getBonusNumber();
    }

    private int validatePrice(String input){
        int inputInt = 0;

        try{
            inputInt = Integer.parseInt(input);
        } catch(Exception e) {
            System.out.println("[ERROR] 구입금액은 정수이어야 합니다.");
            throw new IllegalArgumentException();
        }

        if(inputInt % 1000 != 0){
            System.out.println("[ERROR] 구입금액은 천원 단위이어야 합니다.");
            throw new IllegalArgumentException();
        }
        return inputInt / 1000;
    }

    public void getWinningNumber(){
        String[] input;
        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine().split(",");
        Lotto lotto = new Lotto(validateWinningNumber(input));
    }

    public int getBonusNumber(){
        String input;
        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine();
        validateBonusNumber(input);
    }

    public List<Integer> validateWinningNumber(String[] input){
        List<Integer> inputList = null;
        try{
            for (int i = 0; i < input.length; i++) {
                inputList.add(Integer.parseInt(input[i]));
            }
        } catch(Exception e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return inputList;
    }

    public int validateBonusNumber(String input){
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

}
