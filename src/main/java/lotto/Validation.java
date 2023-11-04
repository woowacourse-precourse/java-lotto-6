package lotto;

import lotto.domain.Lotto;

public class Validation {

    /**
     * 숫자의 단위를 검사한다.
     *
     * @param number : 검사할 숫자
     * @param unit   : 단위
     * @throws IllegalArgumentException : 단위가 맞지 않는 경우
     */
    public static void isCorrectUnit(int number, int unit) throws IllegalArgumentException {
        if (number % unit != 0) {
            throw new IllegalArgumentException("[ERROR] " + unit + " 단위의 수를 입력해야 합니다.");
        }
    }

    /**
     * 최솟값보다 큰 수인지 검사한다.
     *
     * @param number : 검사할 숫자
     * @param min    : 최솟값
     * @throws IllegalArgumentException : 최솟값 보다 작은 경우
     */
    public static void isOver(int number, int min) throws IllegalArgumentException {
        if (number <= min) {
            throw new IllegalArgumentException("[ERROR] " + min + " 보다 큰 수를 입력해야 합니다.");
        }
    }

    /**
     * 숫자가 유효 범위 내에 속하는지 검사한다.
     *
     * @param number : 범위를 검사할 숫자
     * @throws IllegalArgumentException : 1 ~ 45 범위 밖의 숫자인 경우
     */
    public static void isInRange(int number, int min, int max) throws IllegalArgumentException {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] " + min + " ~ " + max + " 범위의 숫자만 가능합니다.");
        }
    }

    /**
     * 번호가 로또와 중복되는지 검사하는 함수
     *
     * @param lotto  : 로또
     * @param number : 번호
     * @throws IllegalArgumentException : 번호가 중복되는 경우
     */
    public static void isDuplicate(Lotto lotto, int number) throws IllegalArgumentException {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}