package assembly;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pmatusiak
 */
public class LineStartup {


//    First employee places all PLCs into RUN mode
    private static List<PLC> firstEmployee(int numberOfPLCs){
        return Stream.generate(() -> new PLC(Mode.RUN))
                .limit(numberOfPLCs)
                .collect(Collectors.toList());
    }


    private static int countRUNs(List<PLC> list){
        return (int) list.stream()
                .filter(c -> c.getMode() == Mode.RUN)
                .count();
    }

    public int mainAlgorithm(int numberOfPLCs, int numberOfEmployees){
        final List<PLC> plcList = firstEmployee(numberOfPLCs);
//        Start from 2nd employee
        for (int i = 1; i < numberOfEmployees; i++) {
//            First PLC always gets switched
            plcList.get(0).switchMode();
            for (int j = 0; j < plcList.size(); j++) {
                if(j % (i+1) == 0){
                    plcList.get(j).switchMode();
                }
            }
        }
        return countRUNs(plcList);
    }
}
