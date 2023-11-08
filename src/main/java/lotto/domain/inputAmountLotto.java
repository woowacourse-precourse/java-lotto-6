package lotto.domain;


import lotto.view.ExceptionMessage;

import java.util.Scanner;

public class inputAmountLotto {

    private static final int MIN_NUMBER_OF_LOTTO_TICKETS = 1000;
    private final int inputAmountLotto;


    public inputAmountLotto(String inputAmountLotto){
        int amount = validNumber(inputAmountLotto);
        validNaturalNumber(amount);
        validDivisibleNumber(amount);

        this.inputAmountLotto = amount;
    }

    public int numberOfLottoTickets(){
        return inputAmountLotto / MIN_NUMBER_OF_LOTTO_TICKETS;

    }










    private static int validNumber(String inputAmountLotto){
        try{
            return Integer.parseInt(inputAmountLotto);
        }
        catch(IllegalArgumentException e){
            ExceptionMessage.errorMessage();
            ExceptionMessage.inputMustNumber();
            return getUserInputAndParse();
        }

    }


    private static void validNaturalNumber(int amount){
        if(amount <= 0){
            ExceptionMessage.errorMessage();
            ExceptionMessage.InputMustNaturalNumber();
            getUserInputAndParse();

        }
    }

    private static void validDivisibleNumber(int amount){
        if(amount % MIN_NUMBER_OF_LOTTO_TICKETS != 0){
            ExceptionMessage.errorMessage();
            ExceptionMessage.InputMustDivisibleNumber();
            getUserInputAndParse();
        }
    }

    private static int getUserInputAndParse() {
        Scanner scanner = new Scanner(System.in);
        String inputAmountLotto = scanner.nextLine();
        return validNumber(inputAmountLotto);
    }













}
