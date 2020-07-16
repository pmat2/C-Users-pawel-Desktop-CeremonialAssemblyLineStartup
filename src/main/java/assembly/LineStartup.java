package assembly;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pmatusiak
 */
public class LineStartup {

//    First employee places all PLCs into RUN mode
    private List<PLC> initialize(int numberOfPLCs){
        return Stream.generate(() -> new PLC(Mode.RUN))
                .limit(numberOfPLCs)
                .collect(Collectors.toList());
    }

    private long countRUNs(List<PLC> list){
        return list.stream()
                .filter(c -> c.getMode() == Mode.RUN)
                .count();
    }

    private boolean checkForNegativeArguments(int PLCs, int employees) {
        return PLCs < 0 || employees < 0;
    }

    private boolean checkForZeroArguments(int PLCs, int employees){
        return PLCs == 0 || employees == 0;
    }

    public long mainAlgorithm(int numberOfPLCs, int numberOfEmployees){
        if(checkForNegativeArguments(numberOfPLCs, numberOfEmployees)){throw new IllegalArgumentException("Number of PLCs and employees has to be 0 or greater!");}
        if(checkForZeroArguments(numberOfPLCs, numberOfEmployees)){return 0;}

        final List<PLC> plcList = initialize(numberOfPLCs);
//        Start from 2nd employee
        for (int i = 1; i < numberOfEmployees; i++) {
//            First PLC always gets switched
            plcList.get(0).switchMode();
//            Iterate from second plc - first one gets switched above
            for (int j = 1; j < plcList.size(); j++) {
                if(j % (i+1) == 0){
                    plcList.get(j).switchMode();
                }
            }
        }
        return countRUNs(plcList);
    }
}
