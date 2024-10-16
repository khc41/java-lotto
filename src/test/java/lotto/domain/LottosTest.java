package lotto.domain;

import lotto.enums.Rank;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.Rank.FIRST_RANK;
import static lotto.enums.Rank.SECOND_RANK;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 결과 리스트를 반환한다.")
    void 결과_리스트_반환() {
        Lottos lottos = new Lottos(List.of(InputView.getInstance().getLottoNumbers("1,2,3,4,5,6"), InputView.getInstance().getLottoNumbers("2,3,4,5,6,7")));
        WinnerLotto winner = new WinnerLotto(InputView.getInstance().getLottoNumbers("1,2,3,4,5,6"), new LottoNum(7));
        List<Rank> ranks = lottos.getRanks(winner);
        assertThat(ranks).hasSize(2);
        assertThat(ranks).contains(FIRST_RANK, SECOND_RANK);
    }

    @Test
    @DisplayName("로또 리스트를 받으면 Lottos 객체를 생성한다.")
    void Lottos_객체_생성() {
        List<Lotto> lottos = List.of(InputView.getInstance().getLottoNumbers("1,2,3,4,5,6"), InputView.getInstance().getLottoNumbers("2,3,4,5,6,7"));
        assertThat(new Lottos(lottos).getSize()).isEqualTo(2);
    }
}
