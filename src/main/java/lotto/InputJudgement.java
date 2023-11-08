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

    /**
     * 사용자가 입력한 로또 구입 금액에 대한 유효성을 검증한다.
     * @param inputPurchaseMoney 사용자가 입력한 로또 구매 금액
     * @return 유효한 금액이면 true, 그렇지 않으면 false
     */
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

    /**
     * 사용자가 입력한 로또 구매 금액이 비어있는지 확인한다.
     * @param inputPurchaseMoney 사용자가 입력한 로또 구매 금액
     * @throws IllegalArgumentException 구매 금액이 비어있을 때
     */
    private void checkInputPurchaseMoneyIsNull(Optional<String> inputPurchaseMoney) {
        if(inputPurchaseMoney.isEmpty()){
            throw new IllegalArgumentException("로또 구매 금액이 입력되지 않았습니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구매 금액의 길이가 기준치를 만족하는지 확인한다.
     * 만약 로또 금액이 1000원이라면 입력 길이는 최소 4여야한다.
     * @param inputPurchaseMoney 사용자가 입력한 로또 구매 금액
     * @throws IllegalArgumentException 입력값의 길이가 로또 최소 구매 금액보다 작은 자리수를 가질 때
     */
    private void checkLengthOfInputPurchaseMoney(Optional<String> inputPurchaseMoney) {
        if(inputPurchaseMoney.get().length() < LOTTO_MIN_LENGTH){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 이상입니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구매 금액이 정수 형태인지 확인
     * @param inputPurchaseMoney 사용자가 입력한 로또 구매 금액
     * @throws IllegalArgumentException 구매 금액이 정수형태가 아닐 때
     */
    private void checkInputPurchaseMoneyTypeIsInteger(String inputPurchaseMoney) {
        try {
            Arrays.stream(inputPurchaseMoney.split("")).forEach(str -> Integer.parseInt(str));
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE +"원 이상인 정수여야합니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구매 금액이 로또 최소 구매 금액을 만족하는지 확인
     * @param price 사용자가 입력한 로또 구매 금액
     * @throws IllegalArgumentException 사용자의 입력이 로또 구매 금액의 최소를 미치지 못할 때
     */
    private void checkInputPurchaseMoneyIsEffectiveRange(Integer price) {
        if(price < LOTTO_PRICE){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 단위의 정수여야합니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구매 금액이 로또 1개의 가격에 나누어 떨어지는지 확인
     * @param price 사용자가 입력한 로또 구매 금액
     * @throws IllegalArgumentException 사용자의 입력이 로또 1개의 금액으로 나누어 떨어지지 않을 때
     */
    private void checkInputPurchaseMoneyCanDivideBy1000(Integer price) {
        if(price % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("로또 구매 금액은 " + LOTTO_PRICE + "원 단위의 정수여야합니다.");
        }
    }

    private void printException(String message) {
        System.out.println("[ERROR] "+ message);
    }

    public Integer parseIntegerInputPurchaseMoneyOrBonusNumber(Optional<String> inputPurchaseMoney) {
        return Integer.parseInt(inputPurchaseMoney.get());
    }

    public List<Integer> parseIntegerInputWinningNumbers(Optional<String> inputWinningNumbers) {
        String[] splitWinningNumbers = inputWinningNumbers.get().split(",");
        return Arrays.stream(splitWinningNumbers).mapToInt(Integer::parseInt).boxed().toList();
    }

    /**
     * 사용자가 입력한 로또 당첨 번호가 유효한지 판단
     * @param inputWinningNumber 사용자가 입력한 로또 당첨 번호
     * @return 사용자가 입력한 로또 당첨 번호가 유효하면 true, 그렇지 않으면 false
     */
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

    /**
     * 사용자의 입력이 구분자(,)를 기준으로 6개인지를 확인
     * @param inputWinningNumber 사용자가 입력한 로또 당첨 번호
     * @throws IllegalArgumentException 사용자의 입력이 구분자 기준 6개가 아닐 때
     * @return 구분자로 구분한 List
     */
    private List<String> checkInputLengthOfWinningNumber(Optional<String> inputWinningNumber) {
        List<String> winningNumbers = Arrays.stream(inputWinningNumber.get().split(",")).toList();
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("로또 당첨 번호는 6개입니다.");
        }
        return winningNumbers;
    }

    /**
     * 사용자의 입력값이 정수인지 확인
     * @param inputWinningNumbers 사용자의 입력 값
     * @throws IllegalArgumentException 사용자의 입력 값이 정수가 아닐 때
     * @return 사용자의 입력값을 Integer로 변환한 List
     */
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

    /**
     * 사용자가 입력한 로또 당첨 번호에 중복이 있는지 확인
     * @param winningNumbers 사용자가 입력한 로또 당첨 번호
     * @throws IllegalArgumentException 로또 당첨 번호에 중복이 있을 때
     */
    private void checkInputWinningNumberEachUnique(List<Integer> winningNumbers) {
        List<Integer> distinctWinningNumbers = winningNumbers.stream().distinct().toList();
        if(winningNumbers.size() != distinctWinningNumbers.size()){
            throw new IllegalArgumentException("로또 당첨 번호는 중복이 없어야합니다.");
        }
    }

    /**
     * 사용자가 입력한 보너스 당첨 번호가 유효한지 판단
     * @param inputBonusNumber 사용자가 입력한 보너스 번호
     * @param winningNumbers 로또 당첨 번호
     * @return 보너스 번호가 유효하면 true, 그렇지 않으면 false
     */
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

    /**
     * 사용자가 입력한 보너스 번호가 로또 당첨 번호와 중복되는지 확인
     * @param inputBonusNumber 사용자가 입력한 보너스 번호
     * @param winningNumbers 로또 당첨 번호
     * @throws IllegalArgumentException 사용자가 입력한 보너스 번호와 로또 당첨 번호가 중복될 때
     */
    private void checkInputBonusNumberContainedWinningNumber(Integer inputBonusNumber, List<Integer> winningNumbers) {
        if(winningNumbers.contains(inputBonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야합니다.");
        }
    }
}
