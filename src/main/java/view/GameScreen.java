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
        printLottoQuantity();

        printLottos();
        System.out.println();

        inputWinNumbers();
        //printWinNumbers();
        inputBonusNumber();

        printLottoResult();
        //printWinResult();
        //printBonusResult();

        //printTotalPrizes();
        printProfitRate();
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
    private void printLottos() throws IllegalArgumentException{
        List<Lotto> lottos = this.game.getLottos();
        for(Lotto lotto : lottos)
        {
            System.out.println(lotto);
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

        validateWinNumber(inputNumbers);

        for(String number : inputNumbers){
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }
//    //only for test
//    private void printWinNumbers(){
//        List<Integer> winNumber = this.game.getWinNumber();
//        StringBuilder printer = new StringBuilder();
//        for(int index = 0; index < winNumber.size(); index++){
//            printer.append(winNumber.get(index));
//            if(index != winNumber.size()-1)
//                printer.append(",");
//        }
//        System.out.println(printer);
//    }
    private void printLottoQuantity() {
    System.out.println(this.game.getLottoQuantity()+"개를 구매했습니다.");
}
    private void validateWinNumber(String[] inputNumbers) throws IllegalArgumentException{
        validateWinNumberType(inputNumbers);
        validateWinNumberLength(inputNumbers);
        validateWinNumberRange(inputNumbers);
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

    private void inputBonusNumber(){
        int inputNumber;
        while(true){
            try{
                System.out.println("보너스 번호를 입력해 주세요.");
                inputNumber = inputNumber(Console.readLine());
                this.game.setBonusNumber(inputNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
    private int inputNumber(String number) throws IllegalArgumentException{
        validateBonusNumber(number);
        return Integer.parseInt(number);
    }
    private void validateBonusNumber(String number) throws IllegalArgumentException{
        validateBonusNumberLength(number);
        validateBonusNumberType(number);
        validateBonusNumberRange(number);
    }

    private void validateBonusNumberLength(String inputNumber)
            throws IllegalArgumentException{
        int length = inputNumber.length();
        if(length != 1)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 해요.");
    }
    private void validateBonusNumberType(String inputNumber) throws IllegalArgumentException{
        char[] temp = inputNumber.toCharArray();
        for(char current : temp){
            if(!Character.isDigit(current))
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
        }
    }
    private void validateBonusNumberRange(String inputNumber) throws IllegalArgumentException{
        int currentNumber = Integer.parseInt(inputNumber);
        if(currentNumber < 1 || currentNumber > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45의 범위 안으로 입력해 주세요.");
    }

    private void printLottoResult(){
        String result = this.game.getLottoResult();
        System.out.println(result);
    }
//    //only for test
//    private void printWinResult(){
//        String result = this.game.getWinLottoResult();
//        System.out.println(result);
//    }
//    //only for test
//    private void printBonusResult(){
//        String result = this.game.getBonusLottoResult();
//        System.out.println(result);
//    }
//    //only for test
//    private void printTotalPrizes(){
//        System.out.println(this.game.sumAllPrize());
//    }
    private void printProfitRate(){
        String profitRate = this.game.calculateProfitRate();
        System.out.println("총 수익률은 "+ profitRate+"%입니다.");
    }
}
