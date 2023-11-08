package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputJudgement {
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer LOTTO_MIN_LENGTH = LOTTO_PRICE.toString().length();

    public static Integer getLottoPrice(){
        return LOTTO_PRICE;
    }

    public boolean judgeInputPurchaseMoneyFormat(Optional<String> inputPurchaseMoney) {
        try {
            checkInputPurchaseMoneyIsNull(inputPurchaseMoney);
            checkLengthOfInputPurchaseMoney(inputPurchaseMoney);
            String inputMoney = inputPurchaseMoney.get();
            checkInputPurchaseMoneyTypeIsInteger(inputMoney);
            Integer price = Integer.parseInt(inputMoney);
            checkInputPurchaseMoneyIsEffectiveRange(price);
            checkInputPurchaseMoneyCanDivideBy1000(price);
        }catch(IllegalArgumentException e){
            printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void checkInputPurchaseMoneyIsNull(Optional<String> inputPurchaseMoney) {
        if(inputPurchaseMoney.isEmpty()){
            throw new IllegalArgumentException("로또 구매 금액이 입력되지 않았습니다.");
        }
    }

    private void checkLengthOfInputPurchaseMoney(Optional<String> inputPurchaseMoney) {
        if(inputPurchaseMoney.get().length() < LOTTO_MIN_LENGTH){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 이상입니다.");
        }
    }

    private void checkInputPurchaseMoneyTypeIsInteger(String inputPurchaseMoney) {
        try {
            Arrays.stream(inputPurchaseMoney.split("")).forEach(str -> Integer.parseInt(str));
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE +"원 이상인 정수여야합니다.");
        }
    }

    private void checkInputPurchaseMoneyIsEffectiveRange(Integer price) {
        if(price < LOTTO_PRICE){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 단위의 정수여야합니다.");
        }
    }

    private void checkInputPurchaseMoneyCanDivideBy1000(Integer price) {
        if(price % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 단위의 정수여야합니다.");
        }
    }

    private void printException(String message) {
        System.out.println("[ERROR] "+ message);
    }

    public Integer parseInteger(Optional<String> inputPurchaseMoney) {
        return Integer.parseInt(inputPurchaseMoney.get());
    }

    public List<Integer> parseIntegers(Optional<String> inputWinningNumbers) {
        String[] splitWinningNumbers = inputWinningNumbers.get().split(",");
        return Arrays.stream(splitWinningNumbers).mapToInt(Integer::parseInt).boxed().toList();
    }

    public boolean judgeInputWinningNumberFormat(Optional<String> inputWinningNumber) {
        try {
            checkInputWinningNumberIsNull(inputWinningNumber);
            List<String> inputWinningNumbers = checkInputLengthOfWinningNumber(inputWinningNumber);
            List<Integer> WinningNumbers = checkInputWinningNumberTypeIsInteger(inputWinningNumbers);
            checkInputWinningNumberEffectiveRange(WinningNumbers);
            checkInputWinningNumberEachUnique(WinningNumbers);
        }catch(IllegalArgumentException e){
            printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void checkInputWinningNumberIsNull(Optional<String> inputWinningNumber) {
        if(inputWinningNumber.isEmpty()){
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
    }

    private List<String> checkInputLengthOfWinningNumber(Optional<String> inputWinningNumber) {
        List<String> winningNumbers = Arrays.stream(inputWinningNumber.get().split(",")).toList();
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("로또 당첨 번호는 6개입니다.");
        }
        return winningNumbers;
    }

    private List<Integer> checkInputWinningNumberTypeIsInteger(List<String> inputWinningNumbers) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = inputWinningNumbers.stream().mapToInt(Integer::parseInt).boxed().toList();
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 당첨 번호는 1부터 45사이의 정수입니다.");
        }

        return winningNumbers;
    }

    private void checkInputWinningNumberEffectiveRange(List<Integer> winningNumbers) throws IllegalArgumentException{
        winningNumbers.forEach(number -> isNotInbound(number));
    }

    private void isNotInbound(Integer number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("로또 당첨 번호는 1부터 45사이의 정수입니다.");
        }
    }

    private void checkInputWinningNumberEachUnique(List<Integer> winningNumbers) {
        List<Integer> distinctWinningNumbers = winningNumbers.stream().distinct().toList();
        if(winningNumbers.size() != distinctWinningNumbers.size()){
            throw new IllegalArgumentException("로또 당첨 번호는 중복이 없어야합니다.");
        }
    }

    public boolean judgeInputBonusNumberFormat(Optional<String> inputBonusNumber, List<Integer> winningNumbers) {
        try {
            checkInputBonusNumberIsNull(inputBonusNumber);
            Integer bonusNumber = checkInputBonusNumberTypeIsInteger(inputBonusNumber);
            checkInputBonusNumberEffectiveRange(bonusNumber);
            checkInputBonusNumberContainedWinningNumber(bonusNumber, winningNumbers);
        }catch (IllegalArgumentException e){
            printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void checkInputBonusNumberIsNull(Optional<String> inputBonusNumber) {
        if(inputBonusNumber.isEmpty()){
            throw new IllegalArgumentException("보너스 번호가 입력되지 않았습니다.");
        }
    }

    private Integer checkInputBonusNumberTypeIsInteger(Optional<String> inputBonusNumber) {
        Integer bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputBonusNumber.get());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("보너스 번호는 1부터 45사이의 정수입니다.");
        }

        return bonusNumber;
    }

    private void checkInputBonusNumberEffectiveRange(Integer bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("보너스 번호는 1부터 45사이의 정수입니다.");
        }
    }

    private void checkInputBonusNumberContainedWinningNumber(Integer inputBonusNumber, List<Integer> winningNumbers) {
        if(winningNumbers.contains(inputBonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야합니다.");
        }
    }
}
