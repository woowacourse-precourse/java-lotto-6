package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputUser {
    private String inputMoney;
    private Integer lottoMoney;
    public Integer inputLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        inputMoney = camp.nextstep.edu.missionutils.Console.readLine();
        validateInputMoneyIsInteger(inputMoney);
        lottoMoney = Integer.parseInt(inputMoney);
        validateMoneyIsMultipleOfThousand(lottoMoney);
        return Integer.parseInt(inputMoney);
    }
    public String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputRawWinningNumber = camp.nextstep.edu.missionutils.Console.readLine();
        return inputRawWinningNumber;
    }

    private void validateInputMoneyIsInteger(String inputMoney){
        try {
            Integer.parseInt(inputMoney);
        }catch (NumberFormatException e){
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
        }
    }
    private void validateMoneyIsMultipleOfThousand(Integer lottoMoney){
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
