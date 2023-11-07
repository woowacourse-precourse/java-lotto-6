package lotto.validation;

public class LottoMachineValidation {

    public void validate_inputMoney(String inputMoney){

    }

    private void validate_isInputValue(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }
    }

}
