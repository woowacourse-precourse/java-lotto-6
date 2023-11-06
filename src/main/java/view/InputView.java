package view;

import camp.nextstep.edu.missionutils.Console;
import validator.InputDataValidator;

public class InputView {

    InputDataValidator dataValidator = new InputDataValidator();
    OutputView outputView = new OutputView();

    private String inputData;

    public int getLottoCostData(){
            inputData = Console.readLine();
            try{
                dataValidator.validLottoCostInput(inputData);
            } catch (IllegalArgumentException e){
                outputView.printIlligalLottoCostMessage();
                getLottoCostData();
            }
        return Integer.parseInt(inputData);
    }
}
