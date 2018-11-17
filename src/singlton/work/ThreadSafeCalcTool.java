package singlton.work;

public class ThreadSafeCalcTool {
    public static int totalBMICalcullated=0;
    public static int numberOfCaculations=0;
    private static ThreadSafeCalcTool inst = null;
    private ThreadSafeCalcTool(){}
    public static ThreadSafeCalcTool getInstance() {
        synchronized(ThreadSafeCalcTool.class) {
            if(inst == null) {
                inst = new ThreadSafeCalcTool();
            }
        }
        return inst;
    }
    public void dostuff() {

    }

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
