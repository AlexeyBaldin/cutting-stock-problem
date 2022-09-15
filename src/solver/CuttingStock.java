package solver;

import model.Result;

import java.util.ArrayList;

public interface CuttingStock {
    Result cuttingStock(int length, ArrayList<Integer> permutation);
}
