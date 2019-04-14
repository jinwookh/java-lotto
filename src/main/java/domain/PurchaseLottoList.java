package domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottoList {
    private static final String INITIAL_COMMENT = "개를 구매했습니다.";

    public static List<Lotto> is(int purchaseAmount) {
        int countOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLottos; i++ ) {
            lottos.add(Lotto.isGenerated());
        }

        show(lottos);
        return lottos;
    }

    private static void show(List<Lotto> lottos) {
        System.out.println(lottos.size() + INITIAL_COMMENT);
        for (Lotto lotto : lottos
        ) {
            System.out.println(lotto);
        }
    }
}
