package lotto.controller;

import lotto.model.LottoTicketMoney;
import lotto.model.Percent;
import lotto.model.PriceMoney;
import lotto.model.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultCalculationServiceTest {
    private final LottoTicketMoney lottoTicketMoney = new LottoTicketMoney(4000);
    private ResultCalculationService resultCalculationService = new ResultCalculationService();
    private PriceMoney priceMoney;
    private Percent incomingRate;
    private final List<Ranking> rankingsCriteria =
            List.of(Ranking.SECOND, Ranking.THIRD, Ranking.THIRD, Ranking.NONE);
    private Map<Ranking, Integer> countsCriteria = new HashMap<>();

    @BeforeEach
    void setUpCounts() {
        for (Ranking ranking: Ranking.values()) {
            countsCriteria.put(ranking, 0);
        }
        for (Ranking ranking: rankingsCriteria) {
            int currentCount = countsCriteria.get(ranking);
            countsCriteria.put(ranking, currentCount + 1);
        }
    }

    private void updatePrivateFields() {
        List<Field> privateFields =
                List.of(resultCalculationService
                        .getClass()
                        .getDeclaredFields()
                );
        privateFields.forEach(field -> {
            field.setAccessible(true);
            try {
                if (field.getType() == PriceMoney.class) {
                    priceMoney = (PriceMoney) field.get(resultCalculationService);
                }
                if (field.getType() == Percent.class) {
                    incomingRate = (Percent) field.get(resultCalculationService);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        });
    }

    private void injectPriceMoney(PriceMoney target) {
        try {
            Field field = resultCalculationService.getClass().getDeclaredField("priceMoney");
            field.setAccessible(true);
            field.set(resultCalculationService, target);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    @DisplayName("상금 계산 확인")
    @Test
    void checkWinningPriceCalculation() {
        // given
        PriceMoney priceMoneyCriteria = new PriceMoney(30_000_000 + 1_500_000 * 2);

        // when
        resultCalculationService.calculatePrice(countsCriteria);
        updatePrivateFields();

        // then
        assertThat(priceMoney).isEqualTo(priceMoneyCriteria);
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void checkIncomeRate() {
        // given
        PriceMoney priceMoneyCriteria = new PriceMoney(30_000_000 + 1_500_000 * 2);
        Percent percentCriteria = new Percent(lottoTicketMoney, priceMoneyCriteria);

        // when
        injectPriceMoney(priceMoneyCriteria);
        resultCalculationService.calculateIncomeRate(lottoTicketMoney);
        updatePrivateFields();

        // then
        assertThat(incomingRate).isEqualTo(percentCriteria);
    }
}
