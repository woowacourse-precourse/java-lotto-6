package lotto.domain;

public enum BonusMatchStatus {
    MATCHED {
        @Override
        public boolean matches(boolean bonusMatch) {
            return bonusMatch == true;
        }
    },
    NOT_MATCHED {
        @Override
        public boolean matches(boolean bonusMatch) {
            return bonusMatch == false;
        }
    },
    IRRELEVANT {
        @Override
        public boolean matches(boolean bonusMatch) {
            return true;
        }
    };

    public abstract boolean matches(boolean bonusMatch);
}
