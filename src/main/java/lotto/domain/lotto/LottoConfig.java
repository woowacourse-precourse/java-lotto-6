package lotto.domain.lotto;

enum LottoConfig {

    NUMBERS_COUNT("로또 번호 개수", 6),
    MIN_NUMBER("로또 번호 최소값", 1),
    MAX_NUMBER("로또 번호 최대값", 45);

    private final String description;
    private final int value;

    LottoConfig(String description, int value) {
        this.description = description;
        this.value = value;
    }

    int getValue() {
        return value;
    }

}
