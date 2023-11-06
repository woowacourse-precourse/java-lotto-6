package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.utils.Validator.*;
public class UserInput {
    private int lottoPrice;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public UserInput(){
        this.lottoPrice=0;
        this.winningNumbers= new ArrayList<>();
        this.bonusNumber=0;
    }

    public void inputLottoPrice(){
        String newLottoPrice = Console.readLine();
        // TODO : 입력값 검증
        validateLottoPrice(newLottoPrice);
        this.lottoPrice = Integer.parseInt(newLottoPrice);
    }

    public void inputWinningNumbers(){
        String input = Console.readLine();
        validateWinningNumbers(input);

        this.winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();;
    }

    public void inputBonusNumber(){
        String newBonusNumber = Console.readLine();
        validateBonusNumber(newBonusNumber);
        this.bonusNumber = Integer.parseInt(newBonusNumber);
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateLottoPrice(String input){
        validateNullOrEmpty(input);
        validateIsNumber(input);
    }

    private void validateWinningNumbers(String input){
        validateNullOrEmpty(input);
        validateIsNumbers(input.split(","));
    }


    private void validateBonusNumber(String input){
        validateNullOrEmpty(input);
        validateIsNumber(input);
        validateIsNumberInRange(Integer.parseInt(input));
    }
}
