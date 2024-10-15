package lotto.domain;

import lotto.enums.Rank;
import lotto.service.LottoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final List<Rank> results;
    private final double returnRate;

    public LottoResult(List<Rank> results, int buyPrice) {
        this.results = results;
        this.returnRate = Math.round((double) getPriceTotal() / buyPrice * 100.0) / 100.0;
    }

    public double getReturnRate() {
        return returnRate;
    }

    int getPriceTotal() {
        int result = 0;
        for (Rank rank : this.results) {
            result += rank.getPrice();
        }
        return result;
    }

    public int getWinnerCount(Rank rank) {
        return (int) results.stream()
                .filter(result -> result == rank)
                .count();
    }

    public static LottoResult getLottoResult(Lottos lottos, WinnerLotto winnerLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            int matchedCount = winnerLotto.compareWinningNumber(lotto);
            result.add(Rank.getRank(matchedCount, winnerLotto.isMatchBonus(lotto)));
        }
        return new LottoResult(result, lottos.getSize() * LottoGame.LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) object;
        return Double.compare(getReturnRate(), that.getReturnRate()) == 0 && Objects.equals(results, that.results);
    }
}
