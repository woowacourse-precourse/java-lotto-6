package lotto.view.service;

import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;
import lotto.view.message.OutputMessage;

import java.util.List;

public class ViewOutputServiceImpl implements ViewOutputService {

    @Override
    public void printPurchasedCount(List<LottoDto> lottoDtos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(lottoDtos.size()).append(OutputMessage.MESSAGE_PURCHASED_COUNT).append('\n');

        for (LottoDto lottoDto : lottoDtos) {
            sb.append(lottoDto.getNumbers()).append('\n');
        }
        System.out.println(sb);
    }

    @Override
    public void printTotalStatistics(ResultDto resultDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_FIFTH).append(resultDto.getRanks().get(1)).append(suffixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_FOURTH).append(resultDto.getRanks().get(2)).append(suffixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_THIRD).append(resultDto.getRanks().get(3)).append(suffixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_SECOND).append(resultDto.getRanks().get(4)).append(suffixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_FIRST).append(resultDto.getRanks().get(5)).append(suffixTotalStatistics())
                .append(OutputMessage.MESSAGE_STATISTICS_RETURN_PREFIX).append(resultDto.getRevenue()).append(OutputMessage.MESSAGE_STATISTICS_RETURN_SUFFIX);
        System.out.println(sb);
    }

    public String prefixTotalStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(OutputMessage.MESSAGE_STATISTICS_SECTION_TOP);
        return sb.toString();
    }

    public String suffixTotalStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputMessage.MESSAGE_STATISTICS_EA).append('\n');
        return sb.toString();
    }
}
