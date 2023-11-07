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

        try{
            validateLottoPrice(newLottoPrice);
            this.lottoPrice = Integer.parseInt(newLottoPrice);
        } catch (IllegalArgumentException e){
            inputLottoPrice();
        }
    }

    public void inputWinningNumbers(){
        String input = Console.readLine();

        try{
            validateWinningNumbers(input);
            this.winningNumbers = convertNumbers(input);
        } catch (IllegalArgumentException e){
            inputWinningNumbers();
        }
    }

    public void inputBonusNumber(){
        String newBonusNumber = Console.readLine();

        try{
            validateBonusNumber(newBonusNumber);
            this.bonusNumber = Integer.parseInt(newBonusNumber);
        } catch (IllegalArgumentException e){
            inputBonusNumber();
        }

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

    public List<Integer> convertNumbers(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateLottoPrice(String input){
        validateNullOrEmpty(input);
        validateIsNumber(input);
        validatePriceRange(input);
    }

    private void validateWinningNumbers(String input){
        validateNullOrEmpty(input);
        validateIsNumbers(input.split(","));
        validateNumbersLength(convertNumbers(input));
        validateIsNumbersInRange(convertNumbers(input));
    }

    private void validateBonusNumber(String input){
        validateNullOrEmpty(input);
        validateIsNumber(input);
        validateIsNumberInRange(Integer.parseInt(input));
    }
}
