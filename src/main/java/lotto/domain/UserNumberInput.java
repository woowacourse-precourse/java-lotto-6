package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserNumberInput {
    private List<Integer> prizeNumbers;
    private int bonusNumber;

    public List<Integer> prizeNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");

        prizeNumbers = Arrays.stream(Console.readLine().split(","))
                .filter(s -> s.matches("\\d+")) // 숫자만 필터링하는 정규 표현식
                .map(Integer::parseInt)
                .toList();

        try{
            new Lotto(prizeNumbers);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return prizeNumberInput();
        }
        bonusNumberInput();
        return prizeNumbers;
    }

    public int bonusInput(){
        return bonusNumber;
    }

    public void bonusNumberInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumberInput = Integer.parseInt(Console.readLine());

        try{
            bonusValidate(bonusNumberInput);
            bonusNumber = bonusNumberInput;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bonusNumberInput();
        }
    }

    private void bonusValidate(int bonusNumber){
        if (prizeNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 없는 번호여야 합니다.");
        } else if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자여야 합니다.");
        }
    }
}
