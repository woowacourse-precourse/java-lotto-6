package model;

public enum Rank {
    PLACE_FIFTH(3),
    PLACE_FOURTH(4),
    PLACE_THIRD(5),
    PLACE_SECOND(7),
    PLACE_FIRST(6);
    private final int rank;

    Rank(int rank){
        this.rank = rank;
    }

}
