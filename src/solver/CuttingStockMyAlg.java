package solver;

import java.util.ArrayList;

public class CuttingStockMyAlg extends CuttingStockBase {
    @Override
    protected void permutationModify(ArrayList<Integer> permutation) {
        permutation.sort((o1, o2) -> o2 - o1);
    }

    @Override
    protected int choosingStrategy(int length, int current, ArrayList<Integer> permutation, ArrayList<Integer> used) {
        int using = -1;
        int diff = length;
        for (int j = 0; j < used.size(); j++) {
            if (used.get(j) >= permutation.get(current)) {
                using = j;
                diff = used.get(j) - permutation.get(current);
            }
        }

        return using;
    }
}
