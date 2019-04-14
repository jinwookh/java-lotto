import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        Lotto winningLottoWithoutBonusNumber = Lotto.isGenerated();
        WinningLotto winningLotto
                = new WinningLotto(winningLottoWithoutBonusNumber, 3);
        for(int i = 0; i<50000; i++) {
            lottos.add(Lotto.isGenerated());
        }

        LottoResult lottoResult = new LottoResult(winningLotto, lottos);
        lottoResult.showMap();



    }
}
