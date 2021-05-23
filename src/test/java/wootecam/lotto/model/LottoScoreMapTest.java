package wootecam.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoScoreMapTest {

	private LottoScoreMap scoreMap;

	@BeforeEach
	void setup() {
		scoreMap = new LottoScoreMap();
		scoreMap.updateScore(LottoResult.FIVE_MATCHING);
		scoreMap.updateScore(LottoResult.FIVE_MATCHING);
		scoreMap.updateScore(LottoResult.FOUR_MATCHING);
		scoreMap.updateScore(LottoResult.THREE_MATCHING);
		scoreMap.updateScore(LottoResult.DEFEAT);
	}

	@Test
	@DisplayName("로또 결과를 위한 모델 초기화테스트")
	void test_scoreMap생성테스트() {
		LottoScoreMap lottoScoreMap = new LottoScoreMap();
		assertThat(lottoScoreMap.getLottoScores()).isNotNull();
	}

	@Test
	@DisplayName("로또 결과가 정상적으로 업데이트 되는지 테스트")
	void test_업데이트() {
		assertThat(scoreMap.getLottoScores().get(LottoResult.FOUR_MATCHING)).isEqualTo(1);
		assertThat(scoreMap.getLottoScores().get(LottoResult.FIVE_MATCHING)).isEqualTo(2);
		assertThat(scoreMap.getLottoScores().get(LottoResult.THREE_MATCHING)).isEqualTo(1);
		assertThat(scoreMap.getLottoScores().get(LottoResult.DEFEAT)).isEqualTo(1);
	}

	@Test
	@DisplayName("setup된 스코어를 기준으로 수익률이 611.00 인지 테스트")
	void testEarningRate() {
		assertThat(scoreMap.getEarningRate()).isEqualTo(611.00);
	}
}