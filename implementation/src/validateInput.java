import Fsm.Event;
import java.util.Scanner;
public class validateInput {
        Scanner input;
        public enum event { PASSIVE, ACTIVE, SYN, SYNACK, ACK, RDATA, SDATA, FIN, CLOSE, TIMEOUT }
        String[] commands;

        validateInput(){
            input = new Scanner(System.in);
            commands = new String[1];
        }
        Boolean er = false;

        public Event getEventFromString(String input) {
            Boolean er = false;
            try {
                event inpEvent = event.valueOf(input);
                if (input.equals("PASSIVE")) {
                    return new fsmEvent.passiveEvent(input);
                } else if (input.equals("ACTIVE")) {
                    return new fsmEvent.activeEvent(input);
                } else if (input.equals("SYN")) {
                    return new fsmEvent.synEvent(input);
                } else if (input.equals("SYNACK")) {
                    return new fsmEvent.synAckEvent(input);
                } else if (input.equals("ACK")) {
                    return new fsmEvent.ackEvent(input);
                } else if (input.equals("RDATA")) {
                    return new fsmEvent.rDataEvent(input);
                } else if (input.equals("SDATA")) {
                    return new fsmEvent.sDataEvent(input);
                } else if (input.equals("FIN")) {
                    return new fsmEvent.finEvent(input);
                } else if (input.equals("CLOSE")) {
                    return new fsmEvent.closeEvent(input);
                } else if (input.equals("TIMEOUT")) {
                    return new fsmEvent.timeoutEvent(input);
                }
            } catch (IllegalArgumentException e) {
                er = true;
                System.out.println("Error: unexpected Event:" + input + "\n");
                return new fsmEvent.invalidEvent("INVALID");
            }
        return new fsmEvent.invalidEvent("INVALID");
        }




}
