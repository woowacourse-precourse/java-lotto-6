package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public Validator() {
    }

    public int validatePurchaseAmountInput(String input) throws IllegalArgumentException {
        validateInteger(input);
        int amount = Integer.parseInt(input);
        validatePositiveInteger(amount);
        validateAmountInThousands(amount);
        return amount;
    }

    private void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.\n");
        }
    }

    private void validatePositiveInteger(int lottoPurchaseCost) {
        if(lottoPurchaseCost<1){
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.\n");
        }
    }

    private void validateAmountInThousands(int lottoPurchaseCost) {
        if(lottoPurchaseCost%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수인 정수를 입력해야 합니다.\n");
        }
    }


    public List<Integer> validateLottoNumbersInput(String input) throws IllegalArgumentException {
        String[] inputInArray = validateSixNumbers(input);
        String[] trimmedElements = trimElements(inputInArray);
        validateNoDuplicates(trimmedElements);
        validateElemnetsAreIntegers(trimmedElements);
        List<Integer> lottoNumbers = putElementsIntoList(trimmedElements);
        validateNumbersRange(lottoNumbers);
        return lottoNumbers;
    }

    private void validateNumbersRange(List<Integer> lottoNumbers) throws IllegalArgumentException {
        for(int lottoNumber:lottoNumbers){
            validateLottoNumberRange(lottoNumber);
        }
    }

    private void validateLottoNumberRange(int lottoNumber) {
        if(lottoNumber<1 || lottoNumber>45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }

    private List<Integer> putElementsIntoList(String[] trimmedElements) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String element:trimmedElements){
            lottoNumbers.add(Integer.parseInt(element));
        }
        return lottoNumbers;
    }

    private void validateElemnetsAreIntegers(String[] trimmedElements) {
        for(String element:trimmedElements){
            validateInteger(element);
        }
    }

    private String[] trimElements(String[] inputInArray) {
        for (int i = 0; i < inputInArray.length; i++) {
            inputInArray[i] = inputInArray[i].trim();
        }
        return inputInArray;
    }

    private void validateNoDuplicates(String[] trimmedElements) {
        Set<String> uniqueInputs = new HashSet<>();
        for(String element:trimmedElements){
            if(!uniqueInputs.add(element)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.\n");
            }
        }
    }

    private String[] validateSixNumbers(String input) {
        String[] inputInArray = input.split(",");
        if(inputInArray.length != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 값을 입력해야 합니다.\n");
        }
        return inputInArray;
    }

    public int validateBonusNumber(String input) throws IllegalArgumentException {
        validateInteger(input);
        int bonusNumber = Integer.parseInt(input);
        validateLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

    public void compareWithLottoNumbers(List<Integer> winningLottoNumbers, int bonusNumber){
        if(winningLottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복되면 안됩니다.\n");
        }

    }


}
