package lotto.dto.input;

public class GetLottoCountDto {
    private final int count;

    public GetLottoCountDto(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
