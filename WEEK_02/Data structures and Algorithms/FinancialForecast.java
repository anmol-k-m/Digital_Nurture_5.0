public class FinancialForecast {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        if (years == 0) {
            return currentValue;
        }

        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double annualGrowthRate = 0.10;
        int years = 5;

        double futureValue = predictFutureValue(currentValue, annualGrowthRate, years);

        System.out.printf("Current Value: %.2f%n", currentValue);
        System.out.printf("Annual Growth Rate: %.2f%%%n", annualGrowthRate * 100);
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);
    }
}