package view;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoGame;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GameScreen {
    final static int WIN_NUMBER_LENGTH = 6;
    LottoGame game;
    public GameScreen(){}

    public void runGame(){
        initialize();
        this.game.printLottoQuantity();

        generateLottos();
        printLottos();
        System.out.println();

        inputWinNumbers();
        printWinNumbers();

    }
    private void initialize(){
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                this.game = new LottoGame(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void printLottos(){
        List<Lotto> lottos = this.game.getLottos();
        for(Lotto lotto : lottos)
        {
            System.out.println(lotto);
        }
    }
    private void generateLottos(){
        try{
            this.game.createLottos();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void inputWinNumbers(){
        List<Integer> inputNumbers;
        while(true){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                inputNumbers = inputNumbers(Console.readLine());
                this.game.setWinNumber(inputNumbers);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private List<Integer> inputNumbers(String input) throws IllegalArgumentException{
        List<Integer> winNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        validateWinNumberType(inputNumbers);
        validateWinNumberLength(inputNumbers);
        validateWinNumberRange(inputNumbers);

        for(String number : inputNumbers){
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }
    //only for test
    private void printWinNumbers(){
        List<Integer> winNumber = this.game.getWinNumber();
        StringBuilder printer = new StringBuilder();
        for(int index = 0; index < winNumber.size(); index++){
            printer.append(winNumber.get(index));
            if(index != winNumber.size()-1)
                printer.append(",");
        }
        System.out.println(printer);
    }
    private void validateWinNumberLength(String[] inputNumbers)
            throws IllegalArgumentException{
        int length = inputNumbers.length;
        if(length != WIN_NUMBER_LENGTH)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 해요.");
    }
    private void validateWinNumberType(String[] inputNumbers) throws IllegalArgumentException{
        StringBuilder numbers = new StringBuilder();
        char[] temp;
        for(String number : inputNumbers){
            numbers.append(number);
        }
        temp = numbers.toString().toCharArray();
        for(char current : temp){
            if(!Character.isDigit(current))
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해 주세요.");
        }
    }
    private void validateWinNumberRange(String[] inputNumbers) throws IllegalArgumentException{
        int currentNumber;
        for(String number : inputNumbers){
            currentNumber = Integer.parseInt(number);
            if(currentNumber < 1 || currentNumber > 45)
                throw new IllegalArgumentException("[ERROR] 각 번호는 1에서 45의 범위 안으로 입력해 주세요.");
        }
    }
}
