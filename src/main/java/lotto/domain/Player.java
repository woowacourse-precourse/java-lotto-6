package lotto.domain;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Lotto> lottos;
    private final Lotto WINNING_NUMBERS;
    private final int BONUS_NUMBER;

    private final int PAYMENT;
    private static int THREE_MATCH = 0;
    private static int FOUR_MATCH = 0;
    private static int FIVE_MATCH = 0;
    private static int FIVE_AND_BONUS_MATCH = 0;
    private static int SIX_MATCH = 0;

    public Player(ArrayList<Lotto> lottos, Lotto winningnumbers, int bonus, int payment) {
        this.lottos = lottos;
        WINNING_NUMBERS = winningnumbers;
        BONUS_NUMBER = bonus;
        PAYMENT = payment;
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWINNING_NUMBERS() {
        return WINNING_NUMBERS;
    }

    public int getBONUS_NUMBER() {
        return BONUS_NUMBER;
    }

    public int getPayment() {
        return PAYMENT;
    }

    public ArrayList<Integer> getMatches() {
        ArrayList<Integer> matches = new ArrayList<Integer>();
        matches.add(THREE_MATCH);
        matches.add(FOUR_MATCH);
        matches.add(FIVE_MATCH);
        matches.add(FIVE_AND_BONUS_MATCH);
        matches.add(SIX_MATCH);
        return matches;
    }

    public static int getThreeMatch() {
        return THREE_MATCH;
    }

    public static int getFourMatch() {
        return FOUR_MATCH;
    }

    public static int getFiveMatch() {
        return FIVE_MATCH;
    }

    public static int getFiveAndBonusMatch() {
        return FIVE_AND_BONUS_MATCH;
    }

    public static int getSixMatch() {
        return SIX_MATCH;
    }

    public void addThreeMatch() {
        THREE_MATCH++;
    }

    public void addFourMatch() {
        FOUR_MATCH++;
    }

    public void addFiveMatch() {
        FIVE_MATCH++;
    }

    public void addFiveAndBonusMatch() {
        FIVE_AND_BONUS_MATCH++;
    }

    public void addSixMatch() {
        SIX_MATCH++;
    }
}
