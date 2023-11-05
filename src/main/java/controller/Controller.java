package controller;

import camp.nextstep.edu.missionutils.Console;
import service.Service;
import view.InputView;

public class Controller {
    private final Service service;

    public void run(){
        System.out.println(getAmountByUserInput());
    }
    public Controller(Service service) {
        this.service = service;
    }
    public int getAmountByUserInput(){
        while(true){
            try {
                InputView.printAskForInputAmount();
                String input = Console.readLine();
                return service.getAmountByUserInput(input);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
