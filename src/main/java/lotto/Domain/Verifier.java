package lotto.Domain;

import lotto.Domain.Constants.LottoRules;
import lotto.View.Constants.ErrorMessage;

import java.util.List;

public class Verifier {

    private static final String COMMA = ",";
    private static final Integer GAME_FEE = LottoRules.GAME_FEE.getNumber();
    private static final Integer MAX_NUM = LottoRules.MAX_LOTTO_BALL_RANGE.getNumber();
    private static final Integer MIN_NUM = LottoRules.MIN_LOTTO_BALL_RANGE.getNumber();

    static ErrorMessage[] err = ErrorMessage.values();

    Verifier() {
    }

    // 입력 관련

    public static void inputNoting(final String input) {
        if(input== null || input.isEmpty()){
            System.out.println(err[8].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void onlyNumberConsist(final String input) {
        if(!input.matches("[0-9]+")){
            System.out.println(err[0].getMessage());
            throw new IllegalArgumentException();
        }
    }

    // 구입 금액 관련

    public static void underOneThousand(final Long input) {
        // 입력한 금액이 1000원 이하인지
        if(input < GAME_FEE) {
            System.out.println(err[1].getMessage());
            throw new IllegalArgumentException("[ERROR]입력한 금액이 1000원 이상이어야 합니다.");
        }
    }

    public static void moduloExist(final Long input) {
        // 1000으로 나눈 나머지가 0인지 확인
        if(input % GAME_FEE != 0){
            System.out.println(err[2].getMessage());
            throw new IllegalArgumentException();
        }
    }

    // 당첨 번호 입력 관련

    public static void onlyNumberAndComma(String input) {
        // 숫자와 콤마로만 이루어져 있는지
        if(!input.matches("^[0-9,]+$")){
            System.out.println(err[3].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void fiveCommas (final String input) {
        // 5개 콤마를 가지고 있는지
        if(input.length() - input.replace(COMMA,"").length() != 5){
            System.out.println(err[4].getMessage());
            throw new IllegalArgumentException();
        }

    }

    public static void winningInput(String winningNumberInput) {
        onlyNumberAndComma(winningNumberInput);
        fiveCommas(winningNumberInput);
    }


    public static void sixBalls (final List<Integer> userInput){
        if(userInput.stream().distinct().count() != 6){
            System.out.println(err[5].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void numberRange(final List<Integer> numbers) {
        //  숫자 값이 1 ~ 45 범위 안에 있는지
        if(!numbers
                .stream()
                .allMatch(x -> x >= MIN_NUM && x <= MAX_NUM)) {
            System.out.println(err[6].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void sameNumberExist (final List<Integer> numbers) {
        // 동일한 숫자를 가지고 있는지
        if(numbers.size() != numbers.stream().distinct().count()) {
            System.out.println(err[7].getMessage());
            throw new IllegalArgumentException();
        }
    }
    public static void winningBall (final List<Integer> numbers){
        sixBalls(numbers);
        numberRange(numbers);
        sameNumberExist(numbers);
    }

    // 보너스 번호 관련

    public static void sameNumberExist (final int input, final List<Integer> numbers){
        // 번호 리스트와 동일한 숫자가 있는지
        if(numbers.contains(input)){
            System.out.println(err[7].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void numberRange(final int number){
        if(number < 1 || number > 45){
            System.out.println(err[6].getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void bonusNumber(final int input, final List<Integer> numbers){
        sameNumberExist(input,numbers);
        numberRange(input);
    }
}
