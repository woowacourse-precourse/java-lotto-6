package domain;

import java.util.ArrayList;

public class CorrectNumbers {

    public int matchThree;
    public int matchFour;
    public int matchFive;
    public int matchFiveAndBonus;
    public int matchSix;

    public CorrectNumbers(ArrayList<Integer> rank) {
        for (int i = 0; i < rank.size(); i++) {
            matchCount(rank.get(i));
        }
    }

    public void matchCount(int rank) {
        if (rank == 1) {
            matchSix++;
        } else if (rank == 2) {
            matchFiveAndBonus++;
        } else if (rank == 3) {
            matchFive++;
        } else if (rank == 4) {
            matchFour++;
        } else if (rank == 5) {
            matchThree++;
        }
    }
}
