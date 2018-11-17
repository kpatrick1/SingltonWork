package singlton.work;

public enum EnumCalcTool {
    INSTANCE;
    public static int totalBMICalcullated=0;
    public static int numberOfCaculations=0;


    private EnumCalcTool() {}


    public static double calcBMI(double height, double weight, CalcTool.MeasurementSystem measurementSystem) {
        double bmi = weight / Math.pow(height,2);
        if (measurementSystem == CalcTool.MeasurementSystem.ENGISH) {
            bmi *= 703;
        }
        totalBMICalcullated+=bmi;
        numberOfCaculations++;

        return bmi;
    }
    public static double averageBMI() {
        return totalBMICalcullated / numberOfCaculations;
    }

}
