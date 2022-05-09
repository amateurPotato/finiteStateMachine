import java.util.Scanner;
import java.util.Arrays;
import Fsm.FSM;
import Fsm.Action;
import Fsm.Event;
import Fsm.Transition;
import Fsm.FsmException;

//Creating the main class

public class fsmMain {

    public static void main(String[] args) throws FsmException{

        int sDataCount = 0;
        int rDataCount = 0;

        // Instantiate all Events
        fsmEvent eventOut = new fsmEvent();
        fsmEvent.passiveEvent ePassive = new fsmEvent.passiveEvent("PASSIVE");
        fsmEvent.activeEvent eActive = new fsmEvent.activeEvent("ACTIVE");
        fsmEvent.ackEvent eAck = new fsmEvent.ackEvent("ACK");
        fsmEvent.synEvent eSyn = new fsmEvent.synEvent("SYN");
        fsmEvent.synAckEvent eSynAck = new fsmEvent.synAckEvent("SYNACK");
        fsmEvent.rDataEvent eRdata = new fsmEvent.rDataEvent("RDATA");
        fsmEvent.sDataEvent eSdata = new fsmEvent.sDataEvent("SDATA");
        fsmEvent.finEvent eFin = new fsmEvent.finEvent("FIN");
        fsmEvent.closeEvent eClose = new fsmEvent.closeEvent("CLOSE");
        fsmEvent.timeoutEvent eTimeOut = new fsmEvent.timeoutEvent("TIMEOUT");


        // Instantiate all states
        fsmStates stateOut = new fsmStates();
        fsmStates.closedState closed = new fsmStates.closedState("CLOSED");
        fsmStates.closingState closing = new fsmStates.closingState("CLOSING");
        fsmStates.closedWaitState close_wait = new fsmStates.closedWaitState("CLOSE_WAIT");
        fsmStates.establishedState established = new fsmStates.establishedState("ESTABLISHED");
        fsmStates.finishWait1State fin_wait_1 = new fsmStates.finishWait1State("FIN_WAIT_1");
        fsmStates.finishWait2State fin_wait_2 = new fsmStates.finishWait2State("FIN_WAIT_2");
        fsmStates.lastAckState last_ack = new fsmStates.lastAckState("LAST_ACK");
        fsmStates.listenState listening = new fsmStates.listenState("LISTEN");
        fsmStates.synSentState syn_sent = new fsmStates.synSentState("SYN_SENT");
        fsmStates.synRcvdState syn_rcvd = new fsmStates.synRcvdState("SYN_RCVD");
        fsmStates.timeWaitState time_wait = new fsmStates.timeWaitState("TIME_WAIT");

        //base fsm class
        FSM fsm = new FSM("ActiveClient", closed);


        // create the transition table as per the diagram
        Transition closedToListen = new Transition(closed, ePassive, listening, new fsmAction.noneAction()); // closed to listen
        fsm.addTransition(closedToListen);

        Transition closedToSynSent = new Transition(closed, eActive, syn_sent, new fsmAction.synAction()); // closed to syn_send
        fsm.addTransition(closedToSynSent);

        Transition listenToClosed = new Transition(listening, eClose, closed, new fsmAction.noneAction());  // listen to send
        fsm.addTransition(listenToClosed);

        Transition listenToSynRecvd = new Transition(listening, eSyn, syn_rcvd, new fsmAction.synAckAction()); // listen to syn recvd
        fsm.addTransition(listenToSynRecvd);

        Transition synRecvdToEstablished = new Transition(syn_rcvd, eAck,  new fsmStates.establishedState("ESTABLISHED"), new fsmAction.noneAction()); // syn recvd to established
        fsm.addTransition(synRecvdToEstablished);

        Transition synRecvdToFinWait1 = new Transition(syn_rcvd, eClose, fin_wait_1, new fsmAction.finAction()); // syn recvd to finished wait 1
        fsm.addTransition(synRecvdToFinWait1);

        Transition finWait1ToFinWait2 = new Transition(fin_wait_1, eAck, fin_wait_2, new fsmAction.noneAction()); // finished wait 1 to finished wait 2
        fsm.addTransition(finWait1ToFinWait2);

        Transition finWait2ToTimeWait = new Transition(fin_wait_2, eFin, time_wait, new fsmAction.ackAction()); // finished wait 2 to time wait
        fsm.addTransition(finWait2ToTimeWait);

        Transition finWait1ToClosing = new Transition(fin_wait_1, eFin, closing, new fsmAction.ackAction()); // finished wait 1 to closing
        fsm.addTransition(finWait1ToClosing);

        Transition closingToTimeWait = new Transition(closing, eAck, time_wait, new fsmAction.noneAction()); //  closing to time wait
        fsm.addTransition(closingToTimeWait);

        Transition timeWaitToClosed = new Transition(time_wait, eTimeOut, closed, new fsmAction.noneAction()); //  time wait to closed
        fsm.addTransition(timeWaitToClosed);

        Transition synSentToClosed = new Transition(syn_sent, eClose, closed, new fsmAction.noneAction()); //  syn sent wait to closed
        fsm.addTransition(synSentToClosed);

        Transition synSentToSynRecvd = new Transition(syn_sent, eSyn, syn_rcvd, new fsmAction.synAckAction()); //  syn sent wait to syn recvd
        fsm.addTransition(synSentToSynRecvd);

        Transition synSentToEstablished = new Transition(syn_sent, eSynAck,  new fsmStates.establishedState("ESTABLISHED"), new fsmAction.noneAction()); //syn sent to established
        fsm.addTransition(synSentToEstablished);

        Transition establishedToCloseWait = new Transition(established, eFin, close_wait, new fsmAction.ackAction()); // established wait to closed wait
        fsm.addTransition(establishedToCloseWait);

        Transition establishedToFinWait1 = new Transition(established, eClose, fin_wait_1, new fsmAction.finAction()); // established wait to finish_wait_1
        fsm.addTransition(establishedToFinWait1);

        Transition finClosingToLastAck = new Transition(close_wait, eClose, last_ack, new fsmAction.finAction()); // finish closeing wait to last ack
        fsm.addTransition(finClosingToLastAck);

        Transition lastAckToClosed = new Transition(last_ack, eAck, closed, new fsmAction.noneAction()); // last ack wait to closed
        fsm.addTransition(lastAckToClosed);

        Transition establishedRdataLoop = new Transition(established, eRdata, established, new fsmAction.noneAction()); // established wait to rdata
        fsm.addTransition(establishedRdataLoop);

        Transition establishedSdataLoop = new Transition(established, eSdata, established, new fsmAction.noneAction()); // established wait to sdata
        fsm.addTransition(establishedSdataLoop);

//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Please provide input string for events, separated by white spaces\n-----------------");
//        String[] eventInput = in.nextLine().split(" ");
//        System.out.println("Received following events\n-----------------");
//        //System.out.println(Arrays.asList(eventInput));
//        String inp;
////        {
////            inp = eventInput[i];
////            try {
////                event inpEvent = event.valueOf( inp );
////                System.out.print(inp + " \n");
////            } catch ( IllegalArgumentException e ) {
////                System.err.println( "No such Event: " + inp);
////            }
////
////        }

//      for (int i = 0; i < eventInput.length; i++)  {
//            inp = eventInput[i];
//            System.out.printf("\nReceived following event: " + inp);
        validateInput validator = new validateInput();
        Scanner input = new Scanner(System.in);
        String inp = input.next();
        while(inp != null) {

            System.out.printf("\nInitial State: "+ fsm.currentState() + " before " + "New Event: "+inp +"\n");
            String last_state = fsm.currentState().getName();
            try {
                fsm.doEvent(validator.getEventFromString(inp));

                if (last_state != "ESTABLISHED" && fsm.currentState().getName().equals("ESTABLISHED")) {
                    // NEW SESSION
                    rDataCount = 0;
                    sDataCount = 0;

                }else if (last_state.equals("ESTABLISHED") && inp.equals("RDATA")) {
                    // RECEIVED NEW DATA
                    rDataCount += 1;
                    System.out.printf("Data recieved: %d\n", rDataCount);

                }else if (last_state.equals("ESTABLISHED") && inp.equals("SDATA")) {
                    // SENT THE DATA
                    sDataCount += 1;
                    System.out.printf("Data sent: %d\n", sDataCount);}
             }catch(FsmException e) {
                if (!validator.er) {
                    System.out.printf("%s\n", e.toString());
                }
           }
            System.out.printf("\nProvide Next Event: \n");
            inp = input.next();
            if (inp.equals("STOP")){
                input.close();
                System.exit(0);
            }
        }
        System.out.println("Processing Event : \n-----------------");
        input.close();
    }

}


