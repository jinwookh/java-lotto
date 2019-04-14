package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> lottoResultMap;

    public LottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        initializeMap();
        adaptMap(winningLotto, lottos);
    }

    private void initializeMap() {
        lottoResultMap = new HashMap<>();
        for (Rank rank : Rank.values()
             ) {
            lottoResultMap.put(rank, 0);
        }
    }

    private void adaptMap(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos
             ) {
            Rank rank = winningLotto.match(lotto);
            incrementMap(rank);
        }
    }

    private void incrementMap(Rank rank) {
        if (lottoResultMap.keySet().contains(rank) == false) {
            throw new IllegalStateException("Map needs to be initialized.");
        }
        int count = lottoResultMap.get(rank);
        lottoResultMap.put(rank, count+1);
    }


    public void showMap() {
        for (Rank rank : Rank.values()
             ) {
            System.out.println("" +rank + lottoResultMap.get(rank));
        }
    }

    private double purchaseAmount() {
        double count = 0;
        for (Rank rank : Rank.values()) {
            count += lottoResultMap.get(rank);
        }

        return count * 1000;
    }

    private double prizeAmount() {
        double prizeAmount = 0;
        for (Rank rank : Rank.values()
             ) {
            prizeAmount += rank.prizeIs() * lottoResultMap.get(rank);
        }

        return prizeAmount;
    }

    public double profitRate() {
        int integer = (int)(prizeAmount() / purchaseAmount() * 10000);
        double profitRate = integer / 100.0;

        return profitRate;
    }

    public void show() {
        LottoResultString.show(lottoResultMap, profitRate());
    }
}
