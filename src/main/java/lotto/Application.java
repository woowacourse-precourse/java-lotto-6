package lotto;


public class Application {
    public static void main(String[] args) {
        
        Input input = new Input();

        int priceAmount = input.priceAmountInput();
        Lotto winningnumbers = input.winningNumberInput(); 
        int bonusNumber = input.bonusNumberInput();

        
    }
}
