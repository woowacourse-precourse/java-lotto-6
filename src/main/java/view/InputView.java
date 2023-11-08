package view;

import camp.nextstep.edu.missionutils.Console;
import util.Splitter;
import validator.InputDataValidator;

public class InputView {

    InputDataValidator dataValidator = new InputDataValidator();
    OutputView outputView = new OutputView();
    Splitter splitter = new Splitter();
    private String inputData;
    private String[] splitWinningData;


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

    public String[] getWinningNumber(){
        while(true){
            try{
                inputData = Console.readLine();
                splitWinningData = splitter.commaSplitter(inputData);
                dataValidator.validWinningNumberInput(splitWinningData);
                break;
            }catch(IllegalArgumentException e){
                outputView.printIlligalWinningNumberMessage();
            }
        }
        return splitWinningData;
    }

    public int getBonusNumber(){
        while(true){
            try{
                inputData = Console.readLine();
                dataValidator.validBonusNumberInput(inputData, splitWinningData);
                break;
            }catch(IllegalArgumentException e){
                outputView.printIlligalWinningNumberMessage();
            }
        }
        return Integer.parseInt(inputData);
    }
}
