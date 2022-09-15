package solver;

import java.util.ArrayList;
import java.util.Collections;

public class CuttingStockMyAlg extends CuttingStockBase {
    @Override
    protected void permutationModify(ArrayList<Integer> permutation) {
        permutation.sort((o1, o2) -> o2 - o1);

    }

    @Override
    protected int choosingStrategy(int length, int current, ArrayList<Integer> permutation, ArrayList<Integer> used) {
        int using = -1;

        for (int j = 0; j < used.size(); j++) {
            if (used.get(j) >= permutation.get(current)) {
                using = j;
                break;
            }
        }

        return using;
    }
}
