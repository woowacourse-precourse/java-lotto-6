package view;

import camp.nextstep.edu.missionutils.Console;
import validator.InputDataValidator;

public class InputView {

    InputDataValidator dataValidator = new InputDataValidator();
    OutputView outputView = new OutputView();

    private String inputData;

    public int getLottoCostData(){
        while(true){
            try{
                inputData = Console.readLine();
                dataValidator.validLottoCostInput(inputData);
                break;
            } catch (IllegalArgumentException e){
                outputView.printIlligalLottoCostMessage();
            }
        }
        return Integer.parseInt(inputData);
    }
}
