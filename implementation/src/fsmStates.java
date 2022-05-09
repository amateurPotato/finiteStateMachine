import Fsm.State;

public class fsmStates{

    public static class closedState extends State {
        private String eState = "CLOSED";
        public closedState(String ev) {
            super(ev);
        }
        public String getEName() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class closedWaitState extends State {
        private String eState = "CLOSE_WAIT";
        public closedWaitState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class closingState extends State {
        private String eState = "CLOSING";
        public closingState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class establishedState extends State {
        private String eState = "ESTABLISHED";
        public establishedState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class finishWait1State extends State {
        private String eState = "FIN_WAIT_1";
        public finishWait1State(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class finishWait2State extends State {
        private String eState = "FIN_WAIT_2";
        public finishWait2State(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class timeoutState extends State {
        private String eState = "TIMEOUT";
        public timeoutState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class synState extends State {
        private String eState = "SYN";
        public synState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class lastAckState extends State {
        private String eState = "LAST_ACK";
        public lastAckState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class listenState extends State {
        private String eState = "LISTEN";
        public listenState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class synRcvdState extends State {
        private String eState = "SYN_RCVD";
        public synRcvdState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class synSentState extends State {
        private String eState = "SYN_SENT";
        public synSentState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }

    public static class timeWaitState extends State {
        private String eState = "TIME_WAIT";
        public timeWaitState(String ev) {
            super(ev);
        }
        public String getEvent() {
            return this.eState;
        }
        public String handle() {
            return new String("State (" + this.eState + ")");
        }
    }
}
