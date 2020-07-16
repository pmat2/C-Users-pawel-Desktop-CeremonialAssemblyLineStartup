package assembly;


/**
 * @author pmatusiak
 */
public class PLC {
    
    private Mode mode;

    public PLC(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void switchMode(){
        if (mode == Mode.PROGRAM){
            mode = Mode.RUN;
        }
        else mode = Mode.PROGRAM;
    }
}
