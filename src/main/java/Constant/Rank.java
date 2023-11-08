package Constant;

public enum Rank {

    FIFTH("3개 일치 (5,000원) - %d개", 5000) {
        @Override
        public boolean isCorrect(int matchedNumberCount, boolean bonus) {
            return matchedNumberCount == 3;
        }
    },
    FORTH("4개 일치 (50,000원) - %d개", 50000) {
        @Override
        public boolean isCorrect(int matchedNumberCount, boolean bonus) {
            return matchedNumberCount == 4;
        }
    },
    THIRD("5개 일치 (1,500,000원) - %d개", 1500000) {
        @Override
        public boolean isCorrect(int matchedNumberCount, boolean bonus) {
            return matchedNumberCount == 5 && !bonus;
        }
    },
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000) {
        @Override
        public boolean isCorrect(int matchedNumberCount, boolean bonus) {
            return matchedNumberCount == 5 && bonus;
        }
    },
    FIRST("6개 일치 (2,000,000,000원) - %d개", 2000000000) {
        @Override
        public boolean isCorrect(int matchedNumberCount, boolean bonus) {
            return matchedNumberCount == 6;
        }
    };

    private final String description;
    private final int reward;

    Rank(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean isCorrect(int matchedNumberCount, boolean bonus);
}
