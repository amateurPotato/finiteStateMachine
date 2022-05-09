import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;

public class fsmAction{

    public static class ackAction extends Action{
        public ackAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }

    public static class finAction extends Action{
        public finAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }

    public static class nAction extends Action{
        public nAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }

    public static class noneAction extends Action{
        public noneAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }

    public static class synAction extends Action{
        public synAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }

    public static class synAckAction extends Action{
        public synAckAction() {}
        @Override
        public void execute(FSM first, Event second) {
            System.out.println("Event " + second.getName() + " received, current state is "+ first.currentState());
        }
    }
}
