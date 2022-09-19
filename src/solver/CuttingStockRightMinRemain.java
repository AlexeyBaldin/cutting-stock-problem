package solver;

import java.util.ArrayList;

public class CuttingStockRightMinRemain extends CuttingStockBase {

    //Обогнал на 1 6 7
    @Override
    protected void permutationModify(int length, ArrayList<Integer> permutation) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();



        for(int i = 0; i < permutation.size(); i++) {
            if(i < permutation.size()/2) {
                left.add(permutation.get(i));
            } else {
                right.add(permutation.get(i));
            }
        }

        ArrayList<Integer> newRight = new ArrayList<>();

        newRight.add(right.remove(0));

        int min = length - newRight.get(0);
        int current = length - newRight.get(0);

        while (right.size() > 0) {

            int minIndex = 0;
            boolean using = false;
            while (!using) {
                for (int i = 0; i < right.size(); i++) {
                    if (current >= right.get(i) && current - right.get(i) < min) {
                        minIndex = i;
                        min = current - right.get(i);
                        using = true;
                    }
                }
                if (using) {
                    current -= right.get(minIndex);
                } else {
                    current = length;
                }
            }

            min = length;
            newRight.add(right.remove(minIndex));
        }

        right.addAll(newRight);

        left.sort((o1, o2) -> o2 - o1);


        permutation.clear();
        permutation.addAll(left);
        permutation.addAll(right);
    }
}
