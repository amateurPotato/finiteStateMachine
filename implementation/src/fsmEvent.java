import Fsm.Event;
public  class fsmEvent{

    public static class ackEvent extends Event{
        public ackEvent(String eName) {  //constructor1
            super(eName);
        }
        public ackEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class activeEvent extends Event{
        public activeEvent(String eName) {  //constructor1
            super(eName);
        }
        public activeEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class closeEvent extends Event{
        public closeEvent(String eName) {  //constructor1
            super(eName);
        }
        public closeEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class finEvent extends Event{
        public finEvent(String eName) {  //constructor1
            super(eName);
        }
        public finEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class invalidEvent extends Event{
        public invalidEvent(String eName) {  //constructor1
            super(eName);
        }
        public invalidEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class passiveEvent extends Event{
        public passiveEvent(String eName) {  //constructor1
            super(eName);
        }
        public passiveEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class rDataEvent extends Event{
        public rDataEvent(String eName) {  //constructor1
            super(eName);
        }
        public rDataEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class sDataEvent extends Event{
        public sDataEvent(String eName) {  //constructor1
            super(eName);
        }
        public sDataEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class synEvent extends Event{
        public synEvent(String eName) {  //constructor1
            super(eName);
        }
        public synEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class synAckEvent extends Event{
        public synAckEvent(String eName) {  //constructor1
            super(eName);
        }
        public synAckEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
    public static class timeoutEvent extends Event{
        public timeoutEvent(String eName) {  //constructor1
            super(eName);
        }
        public timeoutEvent(String eName, Object obj) { //constructor2
            super(eName, obj);
        }
    }
}
