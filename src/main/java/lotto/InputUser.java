package lotto;

import java.util.HashSet;

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
