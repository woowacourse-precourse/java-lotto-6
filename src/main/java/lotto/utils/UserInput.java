package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.Validator.*;
public class UserInput {
    private String lottoPrice;
    private String winningNumbers;
    private String bonusNumber;

    public UserInput(){
        this.lottoPrice="";
        this.winningNumbers="";
        this.bonusNumber="";
    }

    public void inputLottoPrice(){
        String newLottoPrice = Console.readLine();
        // TODO : 입력값 검증
        validateLottoPrice(newLottoPrice);
        this.lottoPrice = newLottoPrice;
    }

    public void inputWinningNumbers(){
        String newWinningNumbers = Console.readLine();
        // TODO : 입력값 검증
        validateWinningNumbers(newWinningNumbers);
        this.winningNumbers = newWinningNumbers;
    }

    public void inputBonusNumber(){
        String newBonusNumber = Console.readLine();
        // TODO : 입력값 검증
        validateBonusNumber(newBonusNumber);
        this.bonusNumber = newBonusNumber;
    }
}
