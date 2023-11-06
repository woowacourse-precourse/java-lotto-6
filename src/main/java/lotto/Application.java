package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> userNumbers = new ArrayList<>();
        
        Input input = new Input();

        int priceAmount = input.priceAmountInput();
        Lotto winningnumbers = input.winningNumberInput(); 
        int bonusNumber = input.bonusNumberInput();

        int lottoAmount = priceAmount / 1000;

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userNumber =  GenerateRandom.getRandomNumbers();
            userNumbers.add(userNumber);
        }

    
        
    }
}
