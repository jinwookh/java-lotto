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
}
