package view;

import camp.nextstep.edu.missionutils.Console;
import util.Splitter;
import validator.InputDataValidator;

public class InputView {

    InputDataValidator dataValidator = new InputDataValidator();
    OutputView outputView = new OutputView();
    Splitter splitter = new Splitter();
    String inputData;

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
        String[] splitData;
        while(true){
            try{
                inputData = Console.readLine();
                splitData = splitter.commaSplitter(inputData);
                dataValidator.validWinningNumberInput(splitData);
                break;
            }catch(IllegalArgumentException e){
                outputView.printIlligalWinningNumberMessage();
            }
        }
        return splitData;
    }

    public int getBonusNumber(){
        while(true){
            try{
                inputData = Console.readLine();
                dataValidator.validBonusNumberInput(inputData);
                break;
            }catch(IllegalArgumentException e){
                outputView.printIlligalWinningNumberMessage();
            }
        }
        return Integer.parseInt(inputData);
    }
}
