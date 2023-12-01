package lotto.domain;

public enum BonusMatchStatus {
    NEED {
        @Override
        public boolean matches(boolean bonusMatch) {
            return bonusMatch;
        }
    },
    NOT_NEED {
        @Override
        public boolean matches(boolean bonusMatch) {
            return !bonusMatch;
        }
    },
    NO_MATTER {
        @Override
        public boolean matches(boolean bonusMatch) {
            return true;
        }
    },
    ;

    public abstract boolean matches(boolean bonusMatch);
}
