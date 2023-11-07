package lotto.validation;

public class LottoMachineValidation {

    public void validate_inputMoney(String inputMoney){

    }

    private void validate_isInputValue(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    private void validate_isPositiveNum(String input){
        int num;
        try {
            num = Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }

        if(num < 0){
            throw new IllegalArgumentException();
        }
    }

}
