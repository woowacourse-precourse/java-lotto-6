package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private static final int TICKET_PRICE = 1000;
    public void game() {
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();
        InputValidator inputValidator = new InputValidator();

        outputManager.printInputAmount();
        String inputBuyingAmount = inputManager.getUserInput();
        int buyingAmount = Integer.parseInt(inputBuyingAmount);
        //buyingAmount 예외 체크
        inputValidator.checkBuyingAmount(buyingAmount);
        inputValidator.checkInputValue(inputBuyingAmount);

        int ticketCount = buyTicket(buyingAmount);
        outputManager.printTicketCount(ticketCount);

        List<List<Integer>> randomNumbers = createRandomNumbers(ticketCount);
        outputManager.printRandomNumber(randomNumbers);

        String input = inputManager.getUserInput();
        List<Integer> winningNumbers = inputManager.splitAndConvertToList(input);
        Collections.sort(winningNumbers);
        Lotto lotto = new Lotto(winningNumbers);
    }

    private int buyTicket(int buyingAmount){
        return buyingAmount / TICKET_PRICE;
    }

    private List<List<Integer>> createRandomNumbers(int ticketCount){
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);

            randomNumbers.add(numbers);
        }
        return randomNumbers;
    }
}
