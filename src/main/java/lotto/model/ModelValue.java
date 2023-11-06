package lotto.model;

enum ModelValue {
    RANK_NUMBER(6),
    FIRST_PLACE(1),
    SECOND_PLACE(2),
    THIRD_PLACE(3),
    FOURTH_PLACE(4),
    FIFTH_PLACE(5);
    private final int modelValue;

    ModelValue(int modelValue) {
        this.modelValue = modelValue;
    }

    public int getModelValue() {
        return this.modelValue;
    }
}