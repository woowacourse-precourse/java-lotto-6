package lotto.dto;

public class ResultDTO {
    public int sameCount;
    public boolean isBonus;

    public ResultDTO(int sameCount, boolean isBonus) {
        this.sameCount = sameCount;
        this.isBonus = isBonus;
    }
}
