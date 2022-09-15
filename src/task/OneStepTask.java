package task;

import model.Result;
import model.Dataset;
import solver.CuttingStock;

public class OneStepTask {

    private final int usingCount;
    private final double deviation;

    public OneStepTask(Dataset dataset, CuttingStock solver) {
        Result result = solver.cuttingStock(dataset.getLength(), dataset.getPermutationCopy());

        this.usingCount = result.getUsingCount();
        this.deviation = (double)(result.getUsingCount() - dataset.getLower()) / dataset.getLower();
    }

    public int getUsingCount() {
        return usingCount;
    }

    public double getDeviation() {
        return deviation;
    }

}
