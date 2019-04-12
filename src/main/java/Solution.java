
import domain.*;

import java.util.*;


public class Solution {

    public static void main(String args[]) {
        int purchaseAmount = Game.getPurchaseAmount();
        List<Lotto> lottoList = Game.generateAndShowLottos(purchaseAmount);
        WinningLotto winning = Game.getWinningLotto();
        LottoResult lottoResult = new LottoResult(lottoList, winning);
        lottoResult.show();
    }
}
