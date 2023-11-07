package lotto.model;

import lotto.utils.Utils;

import static lotto.utils.Constants.LOTTO_DRAW_NUMBER_COUNT;

public class Prize {
    public int[][] GRADE_BOARD;
    public int[] MONEY_BOARD;
    public int[] MATCH_COUNT_BOARD;

    public String[] MESSAGE_BOARD;

    public int GRADE_COUNT = 5;
    public int FIRST_SAME_COUNT = 6;
    public int SECOND_SAME_COUNT = 5;
    public int THIRD_SAME_COUNT = 5;
    public int FOURTH_SAME_COUNT = 4;
    public int FIFTH_SAME_COUNT = 3;
    public int BONUS_BALL_SAME_COUNT = 1;

    public int FIRST_MONEY = 2_000_000_000;
    public int SECOND_MONEY = 30_000_000;
    public int THIRD_MONEY = 1_500_000;
    public int FOURTH_MONEY = 50_000;
    public int FIFTH_MONEY = 5_000;

    public Prize() {
        this.setGradeBoard();
        this.setMoneyBoard();
        this.setMatchCountBoard();
        this.setMessageBoard();
    }


    private int getBonusSameCount(boolean bonusSame) {
        if(bonusSame) {
            return 1;
        }
        return 0;
    }

    public int getGrade(int sameNumbersCount, boolean bonusSame) {
        int bonusSameCount = getBonusSameCount(bonusSame);

        return this.GRADE_BOARD[sameNumbersCount][bonusSameCount];
    }

    public int getMoney(int grade) {
        return this.MONEY_BOARD[grade];
    }

    public String getMessage(int grade) {
        return MESSAGE_BOARD[grade];
    }


    public void setGradeBoard() {
        int rows = FIRST_SAME_COUNT + 1;
        int cols = BONUS_BALL_SAME_COUNT + 1;

        GRADE_BOARD = new int[rows][cols];

        GRADE_BOARD[FIRST_SAME_COUNT][0]
                = GRADE_BOARD[FIRST_SAME_COUNT-1][BONUS_BALL_SAME_COUNT] = 1;

        GRADE_BOARD[SECOND_SAME_COUNT][BONUS_BALL_SAME_COUNT] = 2;

        GRADE_BOARD[THIRD_SAME_COUNT][0]
                = GRADE_BOARD[THIRD_SAME_COUNT-1][BONUS_BALL_SAME_COUNT] = 3;

        GRADE_BOARD[FOURTH_SAME_COUNT][0]
                = GRADE_BOARD[FOURTH_SAME_COUNT-1][BONUS_BALL_SAME_COUNT] = 4;

        GRADE_BOARD[FIFTH_SAME_COUNT][0]
                = GRADE_BOARD[FIFTH_SAME_COUNT-1][BONUS_BALL_SAME_COUNT] = 5;
    }

    public void setMoneyBoard() {
        MONEY_BOARD = new int[GRADE_COUNT + 1];
        MONEY_BOARD[1] = FIRST_MONEY;
        MONEY_BOARD[2] = SECOND_MONEY;
        MONEY_BOARD[3] = THIRD_MONEY;
        MONEY_BOARD[4] = FOURTH_MONEY;
        MONEY_BOARD[5] = FIFTH_MONEY;
    }

    public void setMatchCountBoard() {
        MATCH_COUNT_BOARD = new int[LOTTO_DRAW_NUMBER_COUNT+1];
        MATCH_COUNT_BOARD[1] = FIRST_SAME_COUNT;
        MATCH_COUNT_BOARD[2] = SECOND_SAME_COUNT;
        MATCH_COUNT_BOARD[3] = THIRD_SAME_COUNT;
        MATCH_COUNT_BOARD[4] = FOURTH_SAME_COUNT;
        MATCH_COUNT_BOARD[5] = FIFTH_SAME_COUNT;
    }

    public void setMessageBoard() {
        MESSAGE_BOARD = new String[GRADE_COUNT + 1];
        MESSAGE_BOARD[1] =
                MATCH_COUNT_BOARD[1] + "개 일치 (" + Utils.getFormattedMoney(MONEY_BOARD[1]) + "원)";
        MESSAGE_BOARD[2] =
                MATCH_COUNT_BOARD[2] + "개 일치 보너스 볼 일치 (" + Utils.getFormattedMoney(MONEY_BOARD[2]) + "원)";
        MESSAGE_BOARD[3] =
                MATCH_COUNT_BOARD[3] + "개 일치 (" + Utils.getFormattedMoney(MONEY_BOARD[3]) + "원)";
        MESSAGE_BOARD[4] =
                MATCH_COUNT_BOARD[4] + "개 일치 (" + Utils.getFormattedMoney(MONEY_BOARD[4]) + "원)";
        MESSAGE_BOARD[5] =
                MATCH_COUNT_BOARD[5] + "개 일치 (" + Utils.getFormattedMoney(MONEY_BOARD[5]) + "원)";
    }


}
