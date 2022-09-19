import model.Dataset;
import permutation.PartDownShufflePermutationCreator;
import solver.*;
import task.IterationTask;
import task.OneStepTask;
import util.Reader;

import java.util.ArrayList;

public class Main {

    static ArrayList<Dataset> datasets = Reader.getDatasets();

    public static void main(String[] args) {

        oneStep();
        //iterative(10, 100);

    }

    public static void oneStep() {
        double averageDeviationBaseDescending = 0;
        double averageDeviationMyOneStep = 0;

        for (Dataset dataset : datasets) {
            OneStepTask baseOneStep = new OneStepTask(dataset, new CuttingStockBaseDescending());
            OneStepTask myOneStep = new OneStepTask(dataset, new CuttingStockAverageWithDispersionMinRemain());
            double deviationBase = baseOneStep.getDeviation();
            double deviationMy = myOneStep.getDeviation();
            System.out.println(dataset.getFile());
            System.out.println("    Lower = " + dataset.getLower() + " | baseOneStep = " + baseOneStep.getUsingCount()
                    + ", deviation = " + deviationBase + " | myOneStep = " + myOneStep.getUsingCount()
                    + ", deviation = " + deviationMy);
            averageDeviationBaseDescending += deviationBase;
            averageDeviationMyOneStep += deviationMy;
        }
        averageDeviationBaseDescending /= datasets.size();
        averageDeviationMyOneStep /= datasets.size();
        System.out.println("Average deviation base = " + averageDeviationBaseDescending);
        System.out.println("Average deviation myOneStep = " + averageDeviationMyOneStep);
    }

    public static void iterative(int iterCount, int shuffleCount) {

        for (Dataset dataset : datasets) {
//            IterationTask iterationTask = new IterationTask(iterCount, dataset,
//                    new CuttingStockBase(), new PartDownPermutationCreator());

            IterationTask iterationTask = new IterationTask(iterCount, shuffleCount, dataset,
                    new CuttingStockBase(), new PartDownShufflePermutationCreator());

            OneStepTask baseOneStep = new OneStepTask(dataset, new CuttingStockBaseDescending());

            System.out.println(dataset.getFile());
            System.out.println("    Lower = " + dataset.getLower() +
                    " | baseOneStepSources = " + baseOneStep.getUsingCount() +
                    " | recordSources = " + iterationTask.getRecordSources() +
                    ", recordIter = " + iterationTask.getRecordIter() +
                    ", recordDeviation = " + iterationTask.getRecordDeviation() +
                    ", deviation from base = " + (baseOneStep.getUsingCount() - iterationTask.getRecordSources()));
        }
    }
}




