package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception;
import lotto.model.Lotto;
import lotto.model.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Exception.*;

public class InputController {
    private final Model model;
    public InputController(Model model) {
        this.model = model;
    }

    public int cashToLottoCount(int cash){
        int ticket = cash / 1000;
        model.storeTicketCount(cash);
        return ticket;
    }

    public List<Integer> createWinningLottoList(String inputLottoNumber) {
        return Arrays.stream(inputLottoNumber.split(",")).map(this::checkValidNumberFormat).collect(Collectors.toList());
    }

    public void storeBonusNumber(int bonusNumber){
        model.storeBonusNumber(bonusNumber);
    }

    public void storeLottoTicket(int lottoCount){
        model.storeLottoTicket(lottoCount);
    }

    public void storeLotto(List<Integer> numbers){
        model.storeLotto(numbers);
    }

    public void showLottoTicket() {
        model.getListOfBuyLotto().forEach(i -> System.out.println(i.getNumbers().toString()));
    }

    public int checkValidNumberFormat(String input) {
        try {
            return isValidNumberFormat(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkValidNumberFormat(Console.readLine());
        }
    }

    public void checkRangeLottoNumber(List<Integer> integers){
        try{
            integers.forEach(Exception::isValidLottoNumberRange);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkRangeLottoNumber(createWinningLottoList(Console.readLine()));
        }
    }

    public void checkRangeLottoNumber(int number){
        try{
            isValidLottoNumberRange(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkRangeLottoNumber(checkValidNumberFormat(Console.readLine()));
        }
    }

    public int checkNotThousandAndNegative(int number){
        try {
            isValidNotThousandAndNegativeException(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            int returnNum = checkValidNumberFormat(Console.readLine());
            return checkNotThousandAndNegative(returnNum);
        }
    }

    public Lotto getLotto(){
        return model.getLotto();
    }
}
