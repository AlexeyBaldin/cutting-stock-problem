package solver;

import java.util.ArrayList;
import java.util.Collections;

public class CuttingStockMyAlg extends CuttingStockBase {
    @Override
    protected void permutationModify(ArrayList<Integer> permutation) {
        //permutation.sort((o1, o2) -> o2 - o1);

        ArrayList<Integer> newPermutation = new ArrayList<>();
        int partsCount = 6;
        int pieceInPart = permutation.size() % partsCount == 0 ? permutation.size() / partsCount : permutation.size() / partsCount + 1;
        int k = 0;
        for(int i = 0; i < partsCount; i++) {
            ArrayList<Integer> part = new ArrayList<>();

            for(int j = 0; j < pieceInPart; j++) {
                if(k < permutation.size()) {
                    part.add(permutation.get(k++));
                }
            }

//            if(i%2 == 0) {
//                Collections.shuffle(part);
//            }

            newPermutation.addAll(part);
        }
        permutation.clear();
        permutation.addAll(newPermutation);
    }

//    @Override
//    protected int choosingStrategy(int length, int current, ArrayList<Integer> permutation, ArrayList<Integer> used) {
//        int using = -1;
//
//        for (int j = 0; j < used.size(); j++) {
//            if (used.get(j) >= permutation.get(current)) {
//                using = j;
//                break;
//            }
//        }
//
//        return using;
//    }
}
