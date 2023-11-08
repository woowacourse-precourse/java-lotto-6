package lotto;
import java.util.List;
import java.util.ArrayList;

public class NumbersHandler {
    static final int maxNumber=45;
    private final List<Integer> winningNumbers = new ArrayList<>();
    private final int bonusNumber;

    NumbersHandler(String numbersInput, String bonusNumberInput){
        makeList(numbersInput);
        bonusNumber=convert(bonusNumberInput);
    }

    public void makeList(String numbersInput){
        String[] numbers = numbersInput.split(",");
        for(String number:numbers){
            winningNumbers.add(convert(number));
        }
    }

    public int convert(String number){
        int convertedNumber;
        try {
            convertedNumber = Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return convertedNumber;
    }

    public boolean hasDuplicateOrNotValidNumber(){
        List<Integer> numberCount= new ArrayList<>(maxNumber+1);
        for (int number=0; number<=maxNumber; number++) numberCount.add(0);
        
        for (int number:winningNumbers){
            if(number<1||number>45)return false;
            numberCount.set(number,numberCount.get(number)+1);
            if(numberCount.get(number)>=2)return true;
        }
        return false;
    }

    public List<Integer> convertedWinningNumbers(){
        if(hasDuplicateOrNotValidNumber())throw new IllegalArgumentException();
        return winningNumbers;
    }

    public int convertedBounsNumber() {
        return bonusNumber;
    }
}
