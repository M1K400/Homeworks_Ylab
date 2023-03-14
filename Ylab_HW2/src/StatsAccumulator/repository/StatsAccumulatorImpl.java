package StatsAccumulator.repository;

public class StatsAccumulatorImpl implements StatsAccumulator {

    int minValue = 0;

    int maxValue = 0;

    int countValue = 0;

    int sumValue = 0;

    @Override
    public void add(int value) {
        if (countValue == 0){
            maxValue = value;
            minValue = value;
        } else {
            if (value < minValue){
                minValue = value;

            } else if (value > maxValue){
                maxValue = value;
            }
        }
        sumValue += value;
        countValue++;
    }

    @Override
    public int getMin() {
        return minValue;
    }

    @Override
    public int getMax() {
        return maxValue;
    }

    @Override
    public int getCount() {
        return countValue;
    }

    @Override
    public Double getAvg() {
        return ((double) sumValue / (double) countValue);
    }
}
