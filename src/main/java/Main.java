import assembly.LineStartup;

/**
 * @author pmatusiak
 */
public class Main {

    private static final LineStartup lineStartup = new LineStartup();
    private static final int numberOfEmployees = 1100;
    private static final int numberOfPLCs = 1100;

    public static void main(String[] args) {
        System.out.println("For " + numberOfPLCs +  " PLCs and " +
                numberOfEmployees +  " employees assembly line startup will have " +
                lineStartup.mainAlgorithm(numberOfPLCs, numberOfEmployees) +
                " PLCs in Run mode.");
    }
}
