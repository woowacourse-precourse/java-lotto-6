package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public int purchaseAmount;
    public Lotto lottoAnswer;
    public int bonusNumber;

    public SeveralLotto severalLotto;

    InputNumber(){
        this.purchaseAmount = inputPurchaseAmount();
        initSeveralLotto();
        this.lottoAnswer = new Lotto(inputLottoAnswer());
        this.bonusNumber = inputBonusNumber();
    }

    public int inputPurchaseAmount() {
        String input;
        int money;

        System.out.println(ConstantCollection.QUESTION_1);
        input = Console.readLine();
        validatePurchaseAmountIsNumber(input);
        money = Integer.parseInt(input);
        validatePurchaseAmountThousand(money);

        return money;
    }

    public void validatePurchaseAmountIsNumber(String input){ //입력받은 구입금액이 숫자인지
        char[] inputCharacter= input.toCharArray();
        for (char ch : inputCharacter) {
            checkCharacter(ch);
        }
    }

    public void checkCharacter(char ch){
        if(!Character.isDigit(ch)){
            //System.out.println("[ERROR] 입력 값이 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자여야 합니다.");
        }
    }

    public void validatePurchaseAmountThousand(int input){ //입력받은 구입금액이 1000의 배수인지
        if(input % 1000 != 0){
            System.out.println("[ERROR] 구입금액이 1,000원으로 나누어 떨어지지 않습니다.");
            throw new IllegalArgumentException();
        }
    }



    public List<Integer> inputLottoAnswer() {
        System.out.println(ConstantCollection.QUESTION_2);

        String[] result = Console.readLine().split(",");
        List<Integer> gatherLottoAnswer = new ArrayList<>();
        for (String s : result) {
            gatherLottoAnswer.add(Integer.parseInt(s));
        }

        return gatherLottoAnswer;
    }

    public int inputBonusNumber() {
        String input;
        int bonusNumber;

        System.out.println(ConstantCollection.QUESTION_3);
        input = Console.readLine();
        validateBonusNumberIsNumber(input);
        bonusNumber = Integer.parseInt(input);
        validateBonusNumberduplicate(bonusNumber);

        return bonusNumber;
    }

    public void validateBonusNumberIsNumber(String input){ //입력받은 보너스 번호가 숫자인지
        char[] inputCharacter= input.toCharArray();
        for (char ch : inputCharacter) {
            checkCharacter(ch);
        }
    }

    public void validateBonusNumberduplicate(int input){ //입력받은 보너스 번호가 중복되는지
        lottoAnswer.inputNumberDuplicate(input);
    }


    public void initSeveralLotto(){
        severalLotto = new SeveralLotto(purchaseAmount/1000);
    }
}
