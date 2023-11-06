package lotto.util;

// 게임 과정에서 사용하기 위한 상수들의 모음
public enum GameConstant {
    CONSTANT_LOTTO_MIN_NUMBER(1), // 로또 번호 최소값
    CONSTANT_LOTTO_MAX_NUMBER(45), // 로또 번호 최대값
    CONSTANT_LOTTO_LENGTH(6), // 로또 번호 길이
    CONSTANT_GRADE_LENGTH(5) // 총 등수
    ;
    private final int constant;

    GameConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return this.constant;
    }
}
