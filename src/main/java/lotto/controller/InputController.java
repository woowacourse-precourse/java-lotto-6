package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception;
import lotto.model.single.Lotto;
import lotto.model.db.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Exception.*;
import static lotto.util.Constant.InputClass.COMMA;
import static lotto.util.Constant.InputClass.TICKET_AMOUNT;

public class InputController {
    private final Model model;
    public InputController(Model model) {
        this.model = model;
    }

    public int cashToLottoCount(int cash){
        int ticket = cash / TICKET_AMOUNT;
        model.storeTicketCount(cash);
        return ticket;
    }

    public List<Integer> createWinningLottoList(String inputLottoNumber) {
        return Arrays.stream(inputLottoNumber.split(COMMA)).map(this::checkValidNumberFormat).collect(Collectors.toList());
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

    public void checkStoreLotto(String inputLottoNumber) {
        try{
            checkLottoList(inputLottoNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            checkLottoList(inputLottoNumber);
        }
    }

    private void checkLottoList(String inputLottoNumber) {
        List<Integer> list = createWinningLottoList(inputLottoNumber);
        checkRangeLottoNumber(list);
        storeLotto(list);
    }

    public void showLottoTicket() {
        model.getListOfBuyLotto().forEach(i -> System.out.println(i.getNumbers().toString()));
    }

    public int checkValidNumberFormat(String input) {
        try {
            return isValidNumberFormatException(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkValidNumberFormat(Console.readLine());
        }
    }

    public void checkRangeLottoNumber(List<Integer> integers){
        try{
            integers.forEach(Exception::isValidLottoNumberRangeException);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkRangeLottoNumber(createWinningLottoList(Console.readLine()));
        }
    }

    public void checkRangeLottoNumber(int number){
        try{
            isValidLottoNumberRangeException(number);
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
