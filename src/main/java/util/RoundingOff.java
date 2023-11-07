package util;

public enum RoundingOff {
    SECOND_DECIMAL(100);

    private final double desimal;

    RoundingOff(double desimal) {
        this.desimal = desimal;
    }

    public double get() {
        return desimal;
    }
}
