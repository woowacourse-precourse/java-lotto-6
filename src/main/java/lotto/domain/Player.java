package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.ArrayList;

public class Player {
    private final int PAYMENT;
    private ArrayList<Lotto> lottos;
    private WinningBonusLotto winningBonusLotto;
    private static int THREE_MATCH = 0;
    private static int FOUR_MATCH = 0;
    private static int FIVE_MATCH = 0;
    private static int FIVE_AND_BONUS_MATCH = 0;
    private static int SIX_MATCH = 0;

    public Player(int payment) {
        try {
            validatePaymentUnit(payment);
            PAYMENT = payment;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validatePaymentUnit(int money) {
        if (money % Payment.MONEY_UNIT.getPrize() != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_MESSAGE.getValue());
    }

    public void setLottos(ArrayList<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningBonusLotto(WinningBonusLotto winningBonusLotto) {
        this.winningBonusLotto = winningBonusLotto;
    }

    public WinningBonusLotto getWinningBonusLotto() {
        return winningBonusLotto;
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
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
