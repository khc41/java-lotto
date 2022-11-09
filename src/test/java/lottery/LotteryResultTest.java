package lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    LotteryResult lotteryResult;

    @BeforeEach
    void setUp() {
        EnumMap<LotteryRank, Integer> winningCounts = new EnumMap<>(Map.of(
                LotteryRank.FIFTH, 2,
                LotteryRank.FIRST, 1,
                LotteryRank.NONE, 7
        ));
        lotteryResult = new LotteryResult(winningCounts, LotteryCompany.LOTTERY_PRICE);
    }


    @Test
    void Rank별_당첨_count_확인() {
        assertThat(lotteryResult.winningCounts(LotteryRank.FIFTH)).isEqualTo(2);
        assertThat(lotteryResult.winningCounts(LotteryRank.FIRST)).isEqualTo(1);
    }

    @Test
    void 존재하지_않는_Rank() {
        assertThat(lotteryResult.winningCounts(LotteryRank.SECOND)).isEqualTo(0);
    }

    @Test
    void 수익률_계산() {
        assertThat(lotteryResult.returnRate()).isEqualTo(200001);
    }

}
