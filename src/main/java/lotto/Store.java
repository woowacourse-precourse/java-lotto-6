package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Integer> targetNumbers;
    private List<Integer> bonusNumber;

    public Store() {
        this.targetNumbers = new ArrayList<>();
        this.bonusNumber = new ArrayList<>();
    }

    public void getTargetNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputTargetNumbers = Console.readLine();
        try {
            Validator.targetNumberCheck(inputTargetNumbers);
            setTargetNumbers(inputTargetNumbers);
        } catch (IllegalArgumentException e) {
            getTargetNumbers();
        }
    }

    public void getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputTargetNumbers = Console.readLine();
        try {
            //Validator.targetNumberCheck(inputTargetNumbers);
            //setTargetNumbers(inputTargetNumbers);
        } catch (IllegalArgumentException e) {
            getBonusNumber();
        }
    }

    private void setTargetNumbers(String inputTargetNumbers) {
        String[] splitInputData = inputTargetNumbers.split(",");
        for (int i = 0; i < 6; i++) {
            targetNumbers.add(Integer.parseInt(splitInputData[i]));
        }
    }
}
